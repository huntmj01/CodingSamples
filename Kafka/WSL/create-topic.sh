#!/bin/sh
if [ $# -lt 1 ]
then
    echo "USAGE: create-topic.sh {TOPIC-NAME} {PARTITIONS} {REPLICATION-FACTOR}"
    echo "TOPIC-NAME: The name of the topic to attempt to create"
    echo "PARTITIONS: The number of partitions to create the topic with"
    echo "REPLICATION-FACTOR: The replication factor to set on the topic"
    exit 1
fi
PARTITIONS=1
REPLICATION=1

if [ $# -gt 1 ] 
then
    PARTITIONS=$2
fi
if [ "$#" -gt 2 ] 
then
    REPLICATION=$3
fi

sudo kafka-topics \
    --zookeeper localhost:2181 \
    --create \
    --if-not-exists \
    --partitions $PARTITIONS \
    --replication-factor $REPLICATION \
    --topic $1