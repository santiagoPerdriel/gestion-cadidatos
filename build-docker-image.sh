#!/bin/bash

# Precondiciones

command -v docker >/dev/null 2>&1 || { echo >&2 "Se requiere 'docker' pero no lo tenes instalado. Abortando..."; exit 1; }

usage() { echo "Usage: $0 [-a] [-b] [-u]" 1>&2; exit 1; }


echo "Build mysql "
  docker pull mysql

echo "Build del Backend "
cd back-end/gestion-empleado 
echo pwd

echo "Inicio Build del Backend "
sudo docker build -t backend-empleado .
echo "Fin Build del Backend "

echo "Build del Front "
cd ../../front-end/gestion-empleo
 
echo "Inicio Build del Front "    
sudo docker build -t front-empleado2 .
echo "Fin Build del Backend "

cd ../..

usage() { echo "Usage: $0 [-a] [-b] [-u]" 1>&2; exit 1; }


while getopts "abu" o; do
    case "${o}" in
        a)    
        " docker compose  "        
           docker-compose up -d
          ;;
        b)
		  echo " docker Run  "
		 sudo docker network create gestion_em
		 sudo docker run -d --net gestion_em --name dbMysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=gestion mysql
		 sudo docker run -d --net gestion_em --restart unless-stopped --name backend_api -p 8080:8080 backend-empleado
     sudo docker run -d --net gestion_em --name frontapi -p 4200:4200 front-empleado2:latest 
		    ;;	
        *)
            usage
            ;;
    esac
done
