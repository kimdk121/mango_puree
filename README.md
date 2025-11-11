

# 🍋 MangoPuree
<img width="560" height="486" alt="image" src="https://github.com/user-attachments/assets/0a843cfd-c778-4993-9ded-acc99a068b2b" />

> 실무형 백엔드 템플릿 프로젝트  
> 견적서 자동화, 배치, 모니터링, 예외처리까지 통합한 **운영 가능한 백엔드 아키텍처**

<br>

## 📅 프로젝트 개요

- **프로젝트명**: MangoPuree
- **개발 기간**: 2025.03.20 ~ 2025.04.29
- **개발 환경**: Java 21, Spring Boot 3.4.3, MyBatis, MariaDB, Hadoop, Docker, AWS EC2
- **프로젝트 링크**: http://13.125.26.125:18080/

**설명**: MangoPuree는 제가 이전 회사에서 경험한 스프링 백엔드 프로젝트들을 기반으로, 최신 스프링 부트에서 권장하는 기술들에 맞춰 개선하고 재구성한 개인 프로젝트입니다. '망고'는 당시 회사에서 얻은 실무 경험을 의미하고 '퓨레'는 그 경험을 다지고 정제하여 더 나은 형태로 재구성했다는 의미를 담았습니다.

<br>

## 🛠 기술 스택

| 구분             | 사용 기술                               |
|------------------|------------------------------------------|
| Language         | Java 21                                  |
| Backend Framework| Spring Boot 3.4.3, Spring Security        |
| Template Engine  | Thymeleaf                                |
| ORM              | MyBatis                                   |
| Database         | MariaDB                                   |
| API 문서화       | SpringDoc OpenAPI (Swagger-UI)           |
| File Storage     | Hadoop HDFS 3.4.1                         |
| Monitoring       | Prometheus & Grafana                       |
| Infra            | AWS EC2 (Amazon Linux 2023)               |
| Build Tool       | Gradle 8.5                                |
| Container        | Docker                                    |
| Version Control  | GitHub                                    |

<br>

## 🧱 시스템 구성

<img width="1480" height="648" alt="image" src="https://github.com/user-attachments/assets/d335affa-85bf-4033-970b-ff0a3e0c05ed" />

<br>

## 📁 주요 기능

| 기능 | 설명 |
|------|------|
| **견적서 자동화** | Apache POI + Spire.xls로 Excel/PDF 견적서 자동 생성 |
| **배치 스케줄링** | Spring Scheduler로 외부 API 영상 수집 → HDFS 저장 |
| **메뉴 관리** | DB 기반 계층형 메뉴 트리 및 접근 제어 |
| **예외 처리** | CodeException + ErrorCode enum 기반 공통 예외 구조 |
| **모니터링** | Node Exporter → Prometheus → Grafana로 자원 및 배치 상태 시각화 |
| **Docker 통합** | WAS/DB/모니터링/Hadoop 컨테이너 환경 구성 |

<br>

## 🗃 데이터베이스 설계 (ERD)
![mango_puree](https://github.com/user-attachments/assets/09d899fd-355a-465b-a77f-8c1ca1619042)
| 주요 테이블 | 설명 |
|--------------|------|
| USER - ROLE | Spring Security 기반 사용자 계정 및 권한 관리 |
| MENU - ROLE | 권한별 메뉴 관리 |
| ESTIMATE - ESTIMATE_ITEM | 견적서 및 품목 데이터 관리 |
| NVR_CAMERA / NVR_SCHEDULE | 외부 API로 수집된 카메라 및 스케쥴 데이터 관리 |
| NVR_SCHEDULE_HISTORY - MOVIE | HDFS에 저장된 영상 및 다운로드 이력 관리 |

<br>

## 🧾 API 문서화 (Swagger UI)
[Swagger UI 바로가기](http://13.125.26.125:18080/swagger-ui/index.html)
<img width="1493" height="896" alt="image" src="https://github.com/user-attachments/assets/c0769346-eb12-401f-91c2-bd99e4144435" />
| API 그룹 | 주요 기능 |
|-----------|------------|
| `/api/user` | 사용자 관리 |
| `/api/estimate` | 견적서 생성/조회 |
| `/api/nvrschedule` | 영상 스케줄 등록/수정/삭제 |

<br>

## 🔨 주요 작업내용

- Spring Security Form Login 기반 인증 및 접근 제어 구현
- 사용자 / 견적 / NVR 스케줄 관련 CRUD, API 및 화면 개발
- Spring Scheduler + RestTemplate 기반 외부 API 영상 수집 및 HDFS 저장
- Apache POI + Spire.xls 를 활용한 Excel / PDF 견적서 생성 기능 구현
- Prometheus & Grafana 를 활용한 실시간 모니터링 대시보드 구축
- Custom ErrorCode / CodeException 구조로 공통 예외 처리 체계화
- Docker 기반 WAS/ DB / 모니터링 / Hadoop 컨테이너 구성 및 배포 자동화

<br>

## 💬 프로젝트 후기

-단순히 기능을 구현하는데 그쳤던 지난 시간들을 돌아보며 예전 업무들을 체계적으로 정립할 수 있는 기회가 되었습니다.
-인터넷 강의를 통해 학습한 Spring의 다양한 기능들을 직접 적용하면서 프레임워크의 동작 원리와 사용법을 깊이 이해하게 되었습니다.
-API 설계부터 배포, 모니터링, 예외처리까지 전체 개발 사이클을 직접 설계하고 운영하며 시스템 전반에 대한 흐름과 구조를 스스로 완성해 나가며 자신감을 얻을 수 있었습니다.
