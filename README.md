## 🍋 MangoPuree

> 이전 실무 경험을 최신 스프링 부트 기술로 재정비한 개인 프로젝트입니다.

---

### 📅 프로젝트 개요

- **프로젝트명**: MangoPuree
- **개발 기간**: 2025.03.20 ~ 2025.04.29
- **개발 환경**: Java 21, Spring Boot 3.4.3, MyBatis, MariaDB, Hadoop, Prometheus & Grafana, AWS EC2, Postman Mock Server

**설명**: MangoPuree는 제가 이전 회사에서 경험한 스프링 백엔드 프로젝트들을 기반으로, 최신 스프링 부트에서 권장하는 기술들에 맞춰 개선하고 재구성한 개인 프로젝트입니다. '망고'는 당시 회사에서 얻은 실무 경험을 의미하고 '퓨레'는 그 경험을 다지고 정제하여 더 나은 형태로 재구성했다는 의미를 담았습니다.

---

### 🚀 주요 기능

- Spring Security Form Login 및 Swagger UI JWT 인증 구현
- 사용자 등록, 수정, 삭제, 조회 기능
- DB 기반 트리 구조 메뉴 / 서브메뉴 관리
- Spring Scheduler + RestTemplate로 외부 API 영상 다운로드 후 HDFS 저장
- Apache POI + Spire.XLS 사용한 견적서 Excel/PDF 다운로드 기능
- Prometheus + Grafana를 통한 서버 모니터링 대시보드 구축
- Swagger UI 기반 API 문서화 및 테스트

---

### 🛠 기술 스택

| 구분             | 사용 기술                               |
|------------------|------------------------------------------|
| Language         | Java 21                                  |
| Backend Framework| Spring Boot 3.4.3, Spring Security        |
| Template Engine  | Thymeleaf                                |
| ORM              | MyBatis                                   |
| Database         | MariaDB                                   |
| API 문서화       | SpringDoc OpenAPI (Swagger-UI)           |
| File Storage     | Hadoop HDFS 3.4.1                         |
| Monitoring       | Prometheus, Grafana                       |
| Infra            | AWS EC2 (Amazon Linux 2023)               |
| Build Tool       | Gradle 8.5                                |
| Container        | Docker                                    |
| Version Control  | GitHub                                    |

---

### 🧱 시스템 구성

프로젝트는 AWS EC2 환경에서 Docker를 활용하여 서비스를 컨테이너 단위로 분리 배포했습니다. 영상 저장 처리를 위한 Hadoop은 EC2 내부에 직접 설치되었습니다.

- **EC2 구성요소**
    - **Hadoop**
        - 영상 저장을 위한 HDFS 구성
        - EC2 내부에 직접 설치하여 로컬 다운로드 테스트와 연동 처리 가능
    - **Docker**
        - **WAS** (mango_puree_was)
            - 사용자 관리, 메뉴 트리, 견적서, 영상 다운로드 등 주요 비즈니스 로직 처리
        - **DB** (mango_puree_mariaDB)
            - 사용자, 메뉴, 견적서, 스케쥴 등 데이터 저장
        - **Node Exporter**
            - EC2 시스템 리소스(CPU, 메모리 등) 수집
        - **Prometheus**
            - Node Exporter에서 수집한 메트릭 저장
        - **Grafana**
            - Prometheus 데이터를 기반으로 시각화 대시보드 제공

---

### 🧾 API 문서화 (Swagger UI)

- SpringDoc 기반으로 모든 REST API 문서 자동화
- Swagger UI를 통해 요청/응답 테스트 및 JWT 인증 검증 가능
- 📎 [Swagger UI 바로가기](http://13.125.26.125:18080/swagger-ui/index.html)

---

### 🗃 데이터베이스 설계 (ERD)

- ErdCloud를 사용하여 전체 시스템의 테이블 구조와 관계를 시각적으로 설계하였습니다.
- 사용자, 권한, 메뉴, 코드, 견적서, NVR 스케쥴, 영상 테이블의 관계를 명확히 정의했습니다.
- ![mango_puree](https://github.com/user-attachments/assets/09d899fd-355a-465b-a77f-8c1ca1619042)

---

### 🔨 작업 내용 요약

- Spring Security Form Login, JWT Login 구현
- 사용자, 견적서, NVR 스케쥴 관련 CRUD API 및 화면 기능 구현
- Spring Scheduler 배치 + RestTemplate 사용하여 외부 API (Postman Mock Server) 연동하여 영상 다운로드 → HDFS 저장 기능 구현
- 메뉴 / 서브메뉴 구조를 DB 기반 트리 구조로 설계 및 구현
- Apache POI와 Spire.xls를 사용하여 견적서 Excel/PDF 다운로드 기능 구현
- Prometheus & Grafana 사용하여 실시간 서버 리소스 모니터링 대시보드 구축
- Swagger UI 사용하여 API 문서 자동화 구성
- Custom ErrorCode, CodeException 구조로 공통 예외 처리 체계화
- AWS EC2 인스턴스에 Docker 설치하여 WAS, DB, 모니터링 서버 등을 컨테이너 단위로 분리하여 운영
- Gradle 빌드 및 Docker Was 컨테이너에 배포 스크립트 작성 및 적용

---

### 💬 프로젝트 후기

- 기존 실무 경험을 체계적으로 정리하면서 그동안 사용했던 기능들을 다시 복기할 수 있는 기회가 되었음
- Spring에서 제공하는 다양한 기능들을 직접 구성해보며 사용법을 더 깊이 이해하게 되었음
- API, 배포, 모니터링, 예외처리 등 전체 사이클을 직접 설계/운영하며 시스템 전반에 대한 과정을 이해하게 되었음
