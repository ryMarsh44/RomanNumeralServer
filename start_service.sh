#!/bin/bash

cd RomanNumeralServer
gradle build
./gradlew build
java -jar build/libs/romannumeral_converter-0.1.0.jar