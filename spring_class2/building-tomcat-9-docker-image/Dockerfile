FROM jdk:17.0.3

RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install -y curl
RUN curl https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.62/bin/apache-tomcat-9.0.62.tar.gz --output 'apache-tomcat-9.0.62.tar.gz'
RUN tar -zxvf apache-tomcat-9.0.62.tar.gz
RUN rm apache-tomcat-9.0.62.tar.gz
RUN apt-get purge -y curl
RUN apt-get autoremove -y
RUN apt-get clean

CMD ["./apache-tomcat-9.0.62/bin/catalina.sh", "run"]