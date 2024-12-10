# 1. Alap image (Java 23 JDK)
FROM eclipse-temurin:23-jdk-alpine AS build


# 2. Munkakönyvtár a konténeren belül
WORKDIR /app

# 3. Maven projekt másolása és buildelése
COPY . .
RUN ./mvnw clean package -DskipTests

# 4. Futási környezethez JRE használata
FROM eclipse-temurin:23-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# 5. Port expozíciója
EXPOSE 8080

# 6. Futás
ENTRYPOINT ["java", "-jar", "app.jar"]
