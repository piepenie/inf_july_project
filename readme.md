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