FROM tomcat:10

RUN rm -rf /opt/tomcat/apache-tomcat-10.0.20/webapps/*

COPY ./target/demo-1.0-SNAPSHOT  /opt/tomcat/apache-tomcat-10.0.20/webapps/ROOT.war
#target/demo-1.0-SNAPSHOT.war

CMD ["/opt/tomcat/apache-tomcat-10.0.20/bin/catalina.sh", "run"]