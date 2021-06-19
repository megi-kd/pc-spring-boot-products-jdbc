FROM openjdk:8
ADD target/pc-spring-boot-products.jar pc-spring-boot-products.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","pc-spring-boot-products.jar"]