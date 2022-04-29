FROM tomcat:9

RUN rm -rf ./apache-tomcat-9.0.62/webapps/*

EXPOSE 8080:8080

COPY ./target/spring_class2-1.0.0-SNAPSHOT.war /apache-tomcat-9.0.62/webapps/ROOT.war

CMD ["/apache-tomcat-9.0.62/bin/catalina.sh", "run"]