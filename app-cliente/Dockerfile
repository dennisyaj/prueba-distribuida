# docker build -t app-cliente .
# docker run -d --name authors01 -p 9090:9090 app-cliente

# docker tag app-cliente dennisyaj/app-cliente
# docker login
# docker build -t dennisyaj/app-cliente .
# docker push dennisyaj/app-cliente

FROM eclipse-temurin:17.0.10_7-jre-alpine

RUN mkdir /app
WORKDIR /app

COPY build/quarkus-app/app ./app
COPY build/quarkus-app/lib ./lib
COPY build/quarkus-app/quarkus ./quarkus
COPY build/quarkus-app/quarkus-run.jar app.jar

CMD ["java","-jar","app.jar"]
