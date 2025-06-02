# Etapa 1: Build
FROM gradle:8.7-jdk17-alpine AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# Etapa 2: Runtime
FROM gradle:8.7-jdk17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

# Porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
