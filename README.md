## windows 10 WSL? ?? ?? ??

###  WSL?? ????
1. ????? choco install docker-desktop
2. ????? wsl
3. docker pull mysql
4. (docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 --name mysql)
5. 4 ??? docker ps? ????? ????? ????? ??? ???? ??? <br>images -> ???? -> name=mysql, Environment variables?? MYSQL_ROOT_PASSWORD, 1234? ??
6. ????? docker ps? ????
7. mysql database ??? ??? docker exec -it mysql bash
8. mysql -u root -p
9. create database stock_example;
10. use stock_example;