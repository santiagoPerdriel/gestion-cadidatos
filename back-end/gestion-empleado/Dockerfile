#FROM maven:3.5-jdk-8-alpine
#ADD ./ .
#RUN rm -Rf target && \
#    mvn clean package -Pprod -DskipTests
    
#RUN mv target/*.jar /gestion.war

FROM maven:3.5-jdk-8-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JHIPSTER_SLEEP=0 \
    JAVA_OPTS=""
EXPOSE 8080
EXPOSE 1044
COPY target/*.jar /gestion.war
CMD echo "The application will start in ${JHIPSTER_SLEEP}s..." && \
     java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=1044 -Dspring.profiles.active=docker -jar  /gestion.war
