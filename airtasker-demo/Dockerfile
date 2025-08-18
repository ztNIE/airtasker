FROM maven:3.9.11 AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests

FROM amazoncorretto:17.0.16-alpine3.22
RUN apk --no-cache --update add dumb-init
RUN mkdir /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
COPY --from=build /project/target/airtasker-demo-1.jar /app/airtasker-demo-1.jar
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
# TODO: Follow https://snyk.io/blog/best-practices-to-build-java-containers-with-docker/
CMD ["dumb-init", "java", "-jar", "airtasker-demo-1.jar"]
