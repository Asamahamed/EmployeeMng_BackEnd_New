FROM adoptopenjdk:17-jre-hotspot
EXPOSE 8084
ADD target/fillStack_CRUD.jar spring-boot-mysql.jar
ENTRYPOINT ["java","-jar","/spring-boot-mysql.jar"]