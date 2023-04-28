#!/bin/bash

filename="sqlite-jdbc-3.41.2.1.jar"
url="https://github.com/xerial/sqlite-jdbc/releases/download/3.41.2.1/$filename"
path_destination="lib/$filename"

echo -ne "\nDescargando dependencias..." ""

curl -s -L -o $path_destination $url

if [ $? -eq 0 ]; then
  printf "\r\e[32m[OK]\e[0m Se descargaron todas las dependecias\n"
else
  printf "\r\e[31m[FAIL]\e[0m Al descargar las dependecias\n"
fi
