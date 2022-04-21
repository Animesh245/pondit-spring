FROM ubuntu:20.04

ENV PATH=$PATH:/opt/java/jdk-17.0.2/bin

RUN apt-get -o Acquire::Check-Valid-Until=false -o Acquire::Check-Date=false update
RUN apt-get upgrade -y
RUN apt-get install -y curl
RUN mkdir /opt/java
RUN curl https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz --output 'jdk-17_linux-x64_bin.tar.gz'
RUN tar -zxvf jdk-17_linux-x64_bin.tar.gz
RUN rm jdk-17_linux-x64_bin.tar.gz
#RUN mv jdk-17 /opt/java/jdk-17.0.2
RUN apt-get purge -y curl
RUN apt-get autoremove -y
RUN apt-get clean