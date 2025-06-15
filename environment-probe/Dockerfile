FROM amazoncorretto:24-alpine-full
LABEL maintainer=mcnz.com

# Declare the volume mount point
VOLUME ["/workingdirectory"]

# Document the port the app listens on (does not expose it externally)
EXPOSE 80

# Copy the app
COPY target/app-1.0.jar /app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "/app.jar"]
