#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Por favor, forneça o nome do arquivo Java como parâmetro."
    exit 1
fi

java_file="$1"
javac "${java_file}.java"
jar cfe "${java_file}.jar" "${java_file}" "${java_file}.class"
java -jar "${java_file}.jar"
