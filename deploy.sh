#!/bin/bash

start=$(date +"%s")

ssh -p ${SERVER_PORT} ${SERVER_USER}@${SERVER_HOST} 

docker pull victor005/tangxiaozhi_sports_backend:latest

CONTAINER_NAME=glycemiaapp
if [ "$(docker ps -qa -f name=$CONTAINER_NAME)" ]; then
    if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
        echo "Container is running -> stopping it..."
        docker stop $CONTAINER_NAME;
    fi
fi
ifconfig
docker run -d --rm -p 8000:8000 --name $CONTAINER_NAME victor005/tangxiaozhi_sports_backend:latest

if [ $? -eq 0 ]; then
  echo "Docker run command succeed!"
else
  echo "Docker run command failed!"
fi
docker ps
docker images
end=$(date +"%s")

diff=$(($end - $start))

echo "Deployed in : ${diff}s"
exit 0
