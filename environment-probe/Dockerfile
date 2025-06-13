FROM amazoncorretto:24-alpine-full
LABEL maintainer=mcnz.com
COPY target/app-1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]