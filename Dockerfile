# ── Stage 1: Build ─────────────────────────────────────────────────────────
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Cache dependencies layer separately
COPY pom.xml .
RUN mvn dependency:go-offline -q

COPY src ./src
RUN mvn package -DskipTests -q

# Extract layers for optimised image
RUN java -Djarmode=layertools -jar target/*.jar extract

# ── Stage 2: Runtime ────────────────────────────────────────────────────────
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy layered JAR contents (best-practice for caching)
COPY --from=build /app/dependencies/          ./
COPY --from=build /app/spring-boot-loader/    ./
COPY --from=build /app/snapshot-dependencies/ ./
COPY --from=build /app/application/           ./

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "org.springframework.boot.loader.launch.JarLauncher"]
