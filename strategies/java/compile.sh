#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Por favor, forneça o nome do arquivo Java como parâmetro."
    exit 1
fi

java_file="$1"
players_dir="$2"
javac "${java_file}.java"
jar cfe "${java_file}.jar" "${java_file}" "${java_file}.class"
cp "${java_file}.jar" "$PWD/../${players_dir}"
rm "${java_file}.jar"
rm "${java_file}.class"
echo "$PWD/../${players_dir}"
