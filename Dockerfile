#docker build -t graph-spring .
#from here: https://www.docker.com/blog/kickstart-your-spring-boot-application-development/
FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]