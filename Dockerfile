FROM openjdk:8
ADD target/*.jar appss
ENTRYPOINT ["java","-jar","appss"]