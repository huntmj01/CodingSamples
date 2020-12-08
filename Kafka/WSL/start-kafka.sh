#!/bin/sh
sudo KAFKA_DEBUG=y DEBUG_SUSPEND_FLAG=y connect-distributed -daemon /etc/schema-registry/connect-avro-distributed.properties
sudo rm -r /var/lib/kafka
sudo rm -r /var/lib/zookeeper
sudo zookeeper-server-start -daemon /etc/kafka/zookeeper.properties
sleep 10 # Need to give it time to boot up before starting up services that depend on it
sudo kafka-server-start -daemon /etc/kafka/server.properties
sleep 5
sudo kafka-rest-start -daemon /etc/kafka-rest/kafka-rest.properties
sudo schema-registry-start -daemon /etc/schema-registry/schema-registry.properties
sudo connect-distributed -daemon /etc/schema-registry/connect-avro-distributed.properties