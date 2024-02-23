# docker build -t app-ordenCompra .
# docker run -d --name authors01 -p 9090:9090 app-orden-compra

# docker tag app-ordenCompra dennisyaj/app-orden-compra
# docker login
# docker build -t dennisyaj/app-orden-compra .
# docker push dennisyaj/app-orden-compra

FROM eclipse-temurin:17.0.10_7-jre-alpine

RUN mkdir /app
WORKDIR /app

COPY build/quarkus-app/app ./app
COPY build/quarkus-app/lib ./lib
COPY build/quarkus-app/quarkus ./quarkus
COPY build/quarkus-app/quarkus-run.jar app.jar

CMD ["java","-jar","app.jar"]
