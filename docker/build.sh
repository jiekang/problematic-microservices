#!/bin/bash
echo $PWD

echo "Building $1"
docker build --build-arg SERVICE=$1 -f docker/Dockerfile . -t $1
