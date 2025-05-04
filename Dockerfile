FROM openjdk:21-jdk-slim
RUN apt-get update && apt-get install -y curl \
  && curl -sL https://deb.nodesource.com/setup_20.x | bash - \
  && apt-get install -y nodejs \
  && curl -L https://www.npmjs.com/install.sh | npm_install="10.9.0" | sh
RUN apt-get update && apt-get install -y python3.10

WORKDIR /usr/src/app

COPY . .

RUN cd frontend && npm install
RUN mkdir -p backend/src/main/resources/static
RUN mv frontend/* backend/src/main/resources/static
RUN cd backend && sed -i 's/\r$//' gradlew && chmod +x gradlew
RUN cd backend && ./gradlew build

EXPOSE 8080
CMD ["java", "-jar", "/usr/src/app/backend/build/libs/demo-0.0.1-SNAPSHOT.jar"]