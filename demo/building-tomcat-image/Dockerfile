FROM jdk:17

RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install -y curl
RUN curl https://dlcdn.apache.org/tomcat/tomcat-10/v10.0.20/bin/apache-tomcat-10.0.20.tar.gz --output 'tomcat-10.0.20.tar.gz'
RUN tar -zxvf tomcat-10.0.20.tar.gz
RUN rm tomcat-10.0.20.tar.gz
RUN apt-get purge -y curl
RUN apt-get autoremove -y
RUN apt-get clean

CMD ["./apache-tomcat-10.0.20/bin/catalina.sh", "run"]