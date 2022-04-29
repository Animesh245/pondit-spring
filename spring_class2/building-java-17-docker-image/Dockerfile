FROM ubuntu:20.04

ENV PATH=$PATH:./jdk-17.0.3/bin

RUN apt-get update
RUN apt-get install -y curl
RUN curl https://download.oracle.com/java/17/archive/jdk-17.0.3_linux-x64_bin.tar.gz  --output 'jdk-17.0.3_linux-x64_bin.tar.gz'
RUN tar -zxvf jdk-17.0.3_linux-x64_bin.tar.gz
RUN rm jdk-17.0.3_linux-x64_bin.tar.gz
RUN apt-get purge -y curl
RUN apt-get autoremove -y
RUN apt-get clean
