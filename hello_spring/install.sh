#!/bin/bash

export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/
mvn -f ./pom.xml clean install -DskipTests
STATUS=$?
if [ $STATUS -eq 0 ]; then
  echo "Deployment package generating successful"
  sudo docker image rm -f hello_spring:1.0.0
  sudo docker image build -f Dockerfile -t hello_spring:1.0.0 .
  sudo docker run -p 8083:8080 -it hello_spring:1.0.0

else
  echo "Deployment package generating failed"
  fi

