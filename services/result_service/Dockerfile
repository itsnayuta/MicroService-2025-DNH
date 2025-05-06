# Dùng image Java chính thức
FROM openjdk:17-jdk-slim

# Làm việc trong thư mục /app
WORKDIR /app

# Copy file JAR đã build
COPY target/*.jar app.jar

# Mở cổng 8080
EXPOSE 8080

# Lệnh chạy app
ENTRYPOINT ["java", "-jar", "app.jar"]
