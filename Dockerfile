FROM openjdk:11
COPY target/onlineshop-0.0.1-SNAPSHOT.jar /onlineshop/
CMD ["java","-jar","/onlineshop/onlineshop-0.0.1-SNAPSHOT.jar"]