# Build backend
FROM clojure:openjdk-8-lein-slim-buster AS clojurebuild
# Set up environment
WORKDIR /kyselyynohjaus-build
COPY . .
# uberjar does clean by default if auto-clean is not set false
RUN lein uberjar


# Build actual runtime container
FROM azul/zulu-openjdk-alpine:8-jre AS runtime
WORKDIR /kyselyynohjaus

COPY --from=clojurebuild /kyselyynohjaus-build/target/kyselyynohjaus.jar kyselyynohjaus.jar
# For openshift environments
RUN chmod 0755 kyselyynohjaus.jar

CMD ["java", "-jar", "-Davop_log_path=/kyselyynohjaus/logs", "kyselyynohjaus.jar"]
