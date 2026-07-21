# API 명세서

### 일정 (Schedule)

| 기능 | Method | URL | Request | Response | 상태코드 |
| :--- | :---: | :--- | :---: | :---: | :---: |
| 일정 생성 | POST | /schedules | Param, 요청 body | 등록 정보 | 201 Created |
| 전체 조회 | GET | /schedules | - | 목록 | 200 OK |
| 단건 조회 | GET | /schedules/{scheduleId} | PathVariable | 단건 정보 | 200 OK |
| 일정 수정 | PUT | /schedules/{scheduleId} | PathVariable, 요청 body | 수정 정보 | 200 OK |
| 일정 삭제 | DELETE | /schedules/{scheduleId} | PathVariable | - | 204 No Content |

### 유저 (User)

| 기능 | Method | URL | Request | Response | 상태코드 |
| :--- | :---: | :--- | :---: | :---: | :---: |
| 회원가입 | POST | /users | 요청 body | 등록 정보 | 201 Created |
| 전체 조회 | GET | /users | - | 목록 | 200 OK |
| 단건 조회 | GET | /users/{userId} | PathVariable | 단건 정보 | 200 OK |
| 유저 수정 | PUT | /users/{userId} | PathVariable, 요청 body | 수정 정보 | 200 OK |
| 유저 삭제 | DELETE | /users/{userId} | PathVariable | - | 204 No Content |

## 📐 ERD (테이블 구조)

### 테이블 관계

* `users` 1 : N `schedules` — 유저 한 명은 여러 일정을 작성할 수 있다

---

### users (유저)

| 컬럼 | 타입 | 제약조건 | 설명 |
| :--- | :--- | :--- | :--- |
| id | BIGINT | PK, AUTO_INCREMENT | 유저 고유 식별자 |
| username | VARCHAR(10) | NOT NULL | 유저명 |
| email | VARCHAR(255) | NOT NULL, UNIQUE | 이메일 |
| password | VARCHAR(255) | NOT NULL | 비밀번호 |
| created_at | DATETIME | NOT NULL | 작성일 (JPA Auditing) |
| modified_at | DATETIME | NOT NULL | 수정일 (JPA Auditing) |

### schedules (일정)

| 컬럼 | 타입 | 제약조건 | 설명 |
| :--- | :--- | :--- | :--- |
| id | BIGINT | PK, AUTO_INCREMENT | 일정 고유 식별자 |
| title | VARCHAR(255) | NOT NULL | 할일 제목 |
| content | TEXT | NOT NULL | 할일 내용 |
| user_id | BIGINT | FK -> users.id, NOT NULL | 작성 유저 |
| created_at | DATETIME | NOT NULL | 작성일 (JPA Auditing) |
| modified_at | DATETIME | NOT NULL | 수정일 (JPA Auditing) |
