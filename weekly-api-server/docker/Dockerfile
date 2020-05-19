FROM openjdk:11
RUN mkdir -p /home/weekly
COPY ./target/weekly-api-server-0.0.1-SNAPSHOT.jar /home/weekly
EXPOSE 8080/tcp
ENV SPRING_PROFILES_ACTIVE prod
CMD java -jar /home/weekly/weekly-api-server-0.0.1-SNAPSHOT.jar
