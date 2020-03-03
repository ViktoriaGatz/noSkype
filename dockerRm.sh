#/bin/bash

 docker stop mysql-standalone4

 docker stop spring-rest-service-0.1.0

 docker rm mysql-standalone4

 docker rm spring-rest-service-0.1.0

 docker image rm spring-rest-service-0.1.0:latest
