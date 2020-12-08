#!/bin/sh
if [ $# -lt 2 ]
then
    echo "USAGE: ./produce_message {Topic} {Key Schema File} {Value Schema File}"
    echo "Topic: The topic you want to post a new message to"
    echo "Key Schema File: A Path to a text file containing the avro schema for the record key (Must be on one line)"
    echo "Value Schema File: A Path to a text file containing the avro schema for the record value (Must be on one line)"
    echo "NOTE: If a value schema file is not supplied then it is assumed that the second line in the Key Schema File contains the Value Schema"
    exit 1
fi
KEY_SCHEMA=""
VALUE_SCHEMA=""
if [ $# -eq 2 ]
then
    KEY_SCHEMA=`head -n 1 $2`
    VALUE_SCHEMA=`sed -n '2p' $2`
else
    KEY_SCHEMA=`cat $2`
    VALUE_SCHEMA=`cat $3`
fi
sudo kafka-avro-console-consumer \
    --bootstrap-server localhost:9092 \
    --topic $1 \
    --property key.schema="$KEY_SCHEMA" \
    --from-beginning \
    --property value.schema="$VALUE_SCHEMA"