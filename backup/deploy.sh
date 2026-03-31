#!/bin/bash

# 환경 변수 설정
PROJECT_DIR="/data/mango_puree/mango_puree"  # 프로젝트 디렉토리
BRANCH="main"  # Git 브랜치
JAR_NAME="mangopuree-0.0.1-SNAPSHOT.jar"  # 실행할 JAR 파일 이름
BUILD_DIR="$PROJECT_DIR/build"  # Gradle 빌드 폴더
LOG_FILE="/data/mango_puree/logs/app.log"  # 로그 파일 경로

export DB_ID=mango
export DB_PASSWORD=Kepri123456
export DB_URL=jdbc:log4jdbc:mariadb://13.125.26.125:13306/mango_puree
export PROFILE=prod
export HADOOP_URL=hdfs://13.125.26.125:8020
export JWT_KEY=66ed6rOg7ZOo66CI66ed6rOg7ZOo66CI

echo "배포 스크립트 실행 시작"

# 1. 실행 중인 애플리케이션 종료
echo "실행 중인 애플리케이션 종료 중..."
PID=$(pgrep -f $JAR_NAME)
if [ -n "$PID" ]; then
    kill -9 $PID
    echo "기존 애플리케이션 종료 완료 (PID: $PID)"
else
    echo "기존 애플리케이션이 실행 중이지 않음"
fi

# 2. 프로젝트 디렉토리 이동
cd $PROJECT_DIR || { echo "프로젝트 디렉토리 이동 실패"; exit 1; }

# 3. 최신 코드 가져오기 (Git Pull)
echo "Git에서 최신 코드 가져오는 중..."
git reset --hard origin/$BRANCH
git pull origin $BRANCH
chmod +x gradlew

# 4. 기존 Gradle 빌드 폴더 삭제
echo "기존 Gradle 빌드 폴더 삭제 중..."
rm -rf $BUILD_DIR

# 5. Gradle 빌드 실행
echo "Gradle 빌드 시작..."
./gradlew --no-daemon --max-workers=1 clean build -x test  # 테스트 제외하고 빌드

# 6. 새로운 JAR 실행
echo "새로운 JAR 실행 중..."
nohup java -Xms512m -Xmx700m -jar build/libs/$JAR_NAME > $LOG_FILE 2>&1 &

ps -ef | grep $JAR_NAME

echo "배포 완료"
exit 0
