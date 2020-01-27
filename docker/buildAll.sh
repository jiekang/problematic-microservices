#!/bin/bash

echo $PWD

./docker/build.sh robotshop-customer-service
./docker/build.sh robotshop-factory-service
./docker/build.sh robotshop-order-service
