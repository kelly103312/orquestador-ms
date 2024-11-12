# Etapa 1: Build
FROM maven:3.8.5-eclipse-temurin-17-alpine AS build

# Copiamos el código fuente al contenedor
WORKDIR /app
COPY . .

# Compilamos el proyecto usando Maven
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:17-jre-alpine

# Establecemos el directorio de trabajo en el contenedor
WORKDIR /app

# Copiamos el archivo .jar de la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto en el que correrá la aplicación
EXPOSE 8081

CMD ["java", "-jar", "/app.jar"]