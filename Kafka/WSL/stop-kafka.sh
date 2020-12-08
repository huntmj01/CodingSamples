#!/bin/sh

sudo kafka-rest-stop
sleep 0.5s
sudo schema-registry-stop
sleep 0.5s
sudo kafka-server-stop
sleep 0.5s
sudo zookeeper-server-stop
sleep 0.5s
sudo killall java