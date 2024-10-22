# 🔧 기술 스택
<h4>Backend</h4>
<div>
    <img src="https://img.shields.io/badge/java-F7DF1E?style=flat&logo=java&logoColor=white">
    <img src="https://img.shields.io/badge/springboot-6DB33F?style=flat&logo=springboot&logoColor=white">
    <img src="https://img.shields.io/badge/kafka-231F20?style=flat&logo=apachekafka&logoColor=white">
</div>

<h4>DB</h4>
<div>
    <img src="https://img.shields.io/badge/mariadb-%23003545?style=flat&logo=mariadb&logoColor=white">
</div>

<h4>DB cache</h4>
<div>
    <img src="https://img.shields.io/badge/redis-%23FF4438?style=flat&logo=redis&logoColor=white">
</div>

<h4>Server</h4>
<div>
    <img src="https://img.shields.io/badge/nginx-%23009639?style=flat&logo=nginx&logoColor=white">
</div>

<h4>VCS</h4>
<div>
    <img src="https://img.shields.io/badge/git-F05032?style=flat&logo=git&logoColor=white">
</div>

<h4>OS</h4>
<div>
    <img src="https://img.shields.io/badge/ubuntu-E95420?style=flat&logo=ubuntu&logoColor=white">
</div>

----
# 🚀 주요 기술 
##  ⛓️‍💥 MSA


##  📊 대기열 시스템
### Redis를 이용한 대기열 시스템

<br>

### 분산락

<br>

## 🔗 기타
### OAuth를 이용한 소셜 로그인 (Google, Kakao, NAVER)



1. OAuth를 통해 소셜 ID로 **사용자 인증**을 진행합니다. 
2. 사용자 정보가 DB에 없는 경우, 해당 소셜 ID로 **회원가입**을 진행하며, 이미 존재하는 경우에는 **JWT를 발급**하여 로그인합니다.
3. 발급된 JWT는 **OauthSuccessHandler**를 통해 **Redis**에 저장되어 사용자 인증 상태 유지 및 토큰 유효성 검증에 활용됩니다.
4. 로그아웃 시, Redis에서 **AccessToken**과 **RefreshToken**을 삭제하여 불필요한 세션을 정리하고 보안을 강화합니다.

<br>

### 크론잡(CronJob)을 활용한 게시글 상태 자동 변경

<img src="./docs/img/CronJob.png" alt="크론 잡" width="450">

게시글은 **진행 전**, **진행 중**, **진행 완료**의 세 가지 상태를 가집니다. 게시글 등록 시 '진행 전' 상태에서 시작하며, 오픈 시간에 맞춰 '진행 중'으로, 종료 시간에 '진행 완료'로 변경됩니다.

이를 자동화하기 위해 **게시글 상태를 주기적으로 업데이트**하는 애플리케이션을 **쿠버네티스의 크론잡(CronJob)** 으로 설정했습니다. 자정부터 30분 간격으로 실행되며, **개입 없이도 자동으로 게시글 상태를 갱신**해, 정확한 시간에 게시글이 열리고 닫히는 기능을 구현했습니다.
