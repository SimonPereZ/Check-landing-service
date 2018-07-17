FROM openjdk:8u131-jdk

# install filebeat
ENV FILEBEAT_FILE=filebeat-5.4.1-amd64.deb
RUN wget --no-verbose -O /tmp/${FILEBEAT_FILE} https://artifacts.elastic.co/downloads/beats/filebeat/${FILEBEAT_FILE} \
  && dpkg -i /tmp/${FILEBEAT_FILE} \
  && rm /tmp/${FILEBEAT_FILE}
# configure filebeat
ADD ./src/main/docker/filebeat.yml /etc/filebeat/filebeat.yml

ENV RELEVATE_SERVICE=check-landing-service

ADD ./target/*.jar app.jar
RUN sh -c 'touch /app.jar'

ADD ./src/main/docker/start.sh /app.sh
RUN chmod +x /app.sh
ENTRYPOINT [ "/app.sh" ]
CMD [""]
EXPOSE 8082
