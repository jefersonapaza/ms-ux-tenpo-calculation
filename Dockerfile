# Usa una imagen base de OpenJDK
FROM openjdk:21-jdk-slim

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Define el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo pom.xml y el código fuente al contenedor
COPY pom.xml .
COPY src ./src

# Ejecuta el comando para compilar el JAR (esto genera el JAR dentro del contenedor)
RUN mvn clean package -DskipTests

# Expón el puerto en el que la aplicación escucha
EXPOSE 8080

# Comando para ejecutar la aplicación con el JAR generado
ENTRYPOINT ["java", "-jar", "/app/target/calculation-service-0.0.1-SNAPSHOT.jar"]
