#!/bin/bash

export LOG_FILE=/var/log/${RELEVATE_SERVICE}.json

touch $LOG_FILE
/etc/init.d/filebeat start

java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar