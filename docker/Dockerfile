FROM adoptopenjdk/openjdk11:latest

EXPOSE 9091

RUN mkdir /opt/app
ARG SERVICE
COPY ${SERVICE} /opt/app/
COPY docker/run.sh /opt/app/run.sh
RUN ln -s /opt/app/target/app.jar /opt/app/app.jar
RUN chgrp -R 0 /opt/app && \
    chmod -R g=u /opt/app

USER 1001

WORKDIR /opt/app
CMD /opt/app/run.sh
