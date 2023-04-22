# Team project
<img  src=https://github.com/asd99708/TeamProject/blob/a0bf87b7d71c4c870901394ff43f7d7c95a1c95b/src/main/resources/static/img/%EC%95%88%EC%A4%80%ED%91%9C%ED%8C%80%EC%9B%90.png  width="600" height="400"/>
- 그린 컴퓨터 아카데미 성남점 팀프로젝트 팀원 안준표 포트폴리오 외 2명


## 호텔예약 웹사이트
가상의 중소호텔예약 웹사이트입니다.
- 객실안내
- 객실검색
- 객실예약미리보기
- 호텔소개
- 호텔이용규칙 및 안내 
- 공지사항,회원가입, 로그인
## 템플릿
- https://getbootstrap.kr/


## 목차
- <a href="#01-background">1. Background</a>
- <a href="#02-description">2. Description</a>
- <a href="#03-scope">3. Scope</a>
- <a href="#04-settings">4. Settings</a>
- <a href="#05-database-specification">5. Database Specification</a>
- <a href="#06-erd---diagrams">6. ERD - Diagrams</a>
- <a href="#07-class---diagrams">7. Class - Diagrams</a>
- <a href="#08-development-schedule">8. development schedule</a>
- <a href="#09-view">9. View</a>
- <a href="#10-project-timeline">10. Project Timeline</a>

<hr>

## 01. Background
휴일에도 멀리 여행을 가지 않고, 집 근처의 호텔에서 
가볍게 호캉스를 즐기는 사람들이 늘어나고 있다. 
이러한 수요 때문에 요즘 저가형 중소 호텔도 많이 생기고 있다.
이러한 중소 호텔을 위한 객실예약 & 회원가입 & 검색위주의 사이트 구현

## 02. Description

- 회원가입
- 로그인
- 객실예약미리보기 
- 공지사항
- 지역맞춤 호텔 검색
- 인원에 따라 맞춤 검색

## 03. Scope
![Settings](https://github.com/khe0124/PineTree_Hotel/blob/master/ppt/pt_scope.jpeg?raw=true)

## 04. Settings
프로젝트 작업환경 설정
![Settings](https://github.com/asd99708/TeamProject/blob/90a08578f883b2498e9ad0ffee1b0f1f58d69586/src/main/resources/static/img/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-04-22%20221222.png)

### Settings
항목 | 내용
---|:---
**OS** | Windows10, Windows11 | 
**Language** | Java, HTML, CSS, Javascript |
**Library** | thymeleaf, Bootstrap4, Gradle |
**API** | KaKao Map API|
**Framework** | Spring boot, Bootstrap4 |
**Tools** | dbeaver 버전22.3.2.2, IntelliJ 17.0.5,8.0.32 MySQL Community Server|
**ETC** |  KaKao OvenApp |

## 05. Database Specification
### 1) 총 테이블수
```sql
board(공지사항)
grade(권한)
userinfo(회원가입)
room(객실)
hotel(호텔)
reserve(예약)
```
## 06. ERD - Diagrams
설계된 테이블을 바탕으로 뽑은 ERD- Diagram
![ERD- Diagram](https://github.com/asd99708/TeamProject/blob/f0747850ccde1474b02d98e2c446ad245b73031d/src/main/resources/static/img/%ED%8C%80%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20ERD%20%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A81.jpg)

## 07. class - Diagrams
### 1) 전체 class Diagrams
![Ewireframes-main](https://github.com/asd99708/TeamProject/blob/e8e502732e0ee13f02d9dc9a5d93a59fd8d54a45/src/main/resources/static/img/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-04-22%20224245.png)

### 2) Seach 관점 class Diagrams
![Ewireframes-reservation](https://github.com/asd99708/TeamProject/blob/e8e502732e0ee13f02d9dc9a5d93a59fd8d54a45/src/main/resources/static/img/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-04-22%20224324.png)

## 08. development schedule
![sitemap](https://github.com/asd99708/TeamProject/blob/a06a93d553967519d86c4a2a80003a003141ea18/src/main/resources/static/img/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-04-22%20231302.png)
## 09. View
### 메인페이지
![structure](https://github.com/asd99708/TeamProject/blob/45763bf73773ff40eccc6b55a71ed983ec24471a/src/main/resources/static/img/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-04-22%20232129.png)
### 로그인
![structure](https://github.com/asd99708/TeamProject/blob/1a6d83b0b0a32e54d965208283de187e37c39e74/src/main/resources/static/img/%EB%A1%9C%EA%B7%B8%EC%9D%B8&%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85.png)
### 공지사항
![structure2](https://github.com/asd99708/TeamProject/blob/1a6d83b0b0a32e54d965208283de187e37c39e74/src/main/resources/static/img/%EA%B3%B5%EC%A7%80%EC%82%AC%ED%95%AD%EA%B2%8C%EC%8B%9C%ED%8C%90.png)
### 객실리스트
![structure3](https://github.com/asd99708/TeamProject/blob/1a6d83b0b0a32e54d965208283de187e37c39e74/src/main/resources/static/img/%ED%98%B8%ED%85%94%EC%97%90%20%EB%94%B0%EB%A5%B8%20%EB%A3%B8%EB%A6%AC%EC%8A%A4%ED%8A%B8.png)
### 객실안내사항 및 규정 안내
![structure4](https://github.com/asd99708/TeamProject/blob/1a6d83b0b0a32e54d965208283de187e37c39e74/src/main/resources/static/img/%ED%98%B8%ED%85%94%EC%83%81%EC%84%B8%ED%8E%98%EC%9D%B4%EC%A7%80.png)
### Seach 후 검색 결과
![structure5](https://github.com/asd99708/TeamProject/blob/1a6d83b0b0a32e54d965208283de187e37c39e74/src/main/resources/static/img/%ED%98%B8%ED%85%94%20seach.png)

## 10. Project Timeline
![timeline](https://github.com/khe0124/PineTree_Hotel/blob/master/ppt/pt_timeline.jpeg?raw=true)
 <br>
