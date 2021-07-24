FROM openjdk:11-jre
VOLUME /tmp
EXPOSE 8001
ADD ./target/pruevas-angularjs-alumnos-0.0.1-SNAPSHOT.jar pruevas-angular.jar
ENTRYPOINT ["java","-jar","/pruevas-angular.jar"]