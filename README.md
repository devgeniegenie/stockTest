## windows 10 WSL 이용하여 도커 세팅

###  WSL에서 세팅하기
1. 도커 설치 choco install docker-desktop
2. 터미널에서 wsl
3. docker pull mysql
4. (docker run -d -p 3307:3306 -e MYSQL_ROOT_PASSWORD=1234 --name mysql)
5. 4옵션에서 3307포트에 붙으면 컨테이너 3306포트에 붙겠다는 설정 
6. 4 에서 docker ps로 확인 안되서 Docker desktop이용하여 컨테이너 실행 <br>images -> 엑션버튼 -> name=mysql, Environment variables에 MYSQL_ROOT_PASSWORD, 1234입력
7. wls에서 docker ps로 컨테이너 실행 확인
8. mysql database 실행하기 위해 docker exec -it mysql bash
9. mysql -u root -p
10. create database stock_example;
11. use stock_example;