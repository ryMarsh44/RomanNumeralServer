# RomanNumeralServer

RomanNumeralServer is a Java HTTP Server using Spring Boot. It's purpose is to convert an integer to a roman numeral. 

## How to build RomanNumeralService from source
**Note** This service has only been tested on Ubuntu 16.04.

## Linux 
1) Clone RomanNumeralService: 
    ``` 
    $ git clone git@github.com:ryMarsh44/RomanNumeralServer.git 
    ```
2) install java 8
    ``` 
        $ sudo apt-get update -y && apt-get install -y \
                   openjdk-8-jdk
    ```
3) From the RomanNumeralServer/ folder run the following commands to verify everything works (service will start): 
    ``` 
    $ ./gradlew build
    $ java -jar build/libs/romannumeral_converter-0.1.0.jar
    ``` 
4) Test Service by opening your browser and hitting ``http://localhost:8080/romannumeral?query={Integer}`` 
4) Currently, I am using intellij for IDE development (https://www.jetbrains.com/idea/download/) 

## Run Junit tests
1) JUnit 5 is used
2) Run tests from the command line:
``` $./gradlew clean test ```
 
## Run Docker instance
1) Install Docker
    ``` 
    $ sudo apt-get update
    $ sudo apt-get install apt-transport-https ca-certificates curl software-properties-common 
    $ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
    $ sudo apt-key fingerprint 0EBFCD88
    $ sudo add-apt-repository   "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
    $ sudo apt-get update
    $ sudo apt-get install docker-ce
    $ apt-cache madison docker-ce
    ```
2) Working Directory needs to be RomanNumeralServer: 
    ``` $ cd RomanNumeralServer```
3) Build image: 
    ``` $ docker build -t romannumeral_service . ```
4) Run container: 
    ``` $ docker run --network=host romannumeral_service ```
5) HTTP endpoint is available at ``http://localhost:8080/romannumeral?query={Integer}``

## Built With

* [Gradle](https://gradle.org/) - Dependency Management

## References
1) Roman Numeral Conversion:
    ``https://www.rapidtables.com/convert/number/how-number-to-roman-numerals.html``
2) Java Spring Boot: 
    ``https://spring.io/guides/gs/rest-service/#scratch``
    
## Authors

* **Ryan Marsh** - *Initial work* - (https://github.com/ryMarsh44/RomanNumeralServer)