# Development
FROM ubuntu:16.04

# JRE installation and gcc
RUN apt-get update -y && apt-get install -y \
    apt-transport-https \
    ca-certificates \
    wget \
    git \
    curl \
	sudo \
    openjdk-8-jdk \
    zip \
    vim

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-5.0-bin.zip
RUN mkdir /opt/gradle
RUN unzip -d /opt/gradle gradle-5.0-bin.zip
ENV PATH=$PATH:/opt/gradle/gradle-5.0/bin

# Clone RomanNumeralServer
RUN git clone https://github.com/ryMarsh44/RomanNumeralServer.git

# Build Project
EXPOSE 8080
ENTRYPOINT source start_service.sh