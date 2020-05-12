FROM openjdk:11
RUN mkdir -p /home/philippe
COPY ./target/weekly-api-server-0.0.1-SNAPSHOT.jar /home/philippe
EXPOSE 8080/tcp
CMD java -jar /home/philippe/weekly-api-server-0.0.1-SNAPSHOT.jar
