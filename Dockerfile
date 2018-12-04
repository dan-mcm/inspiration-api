FROM openjdk:8

MAINTAINER Daniel McMahon <daniel40392@gmail.com>

WORKDIR /opt/inspiration-api

ADD . /opt/inspiration-api

ENV SBT_VERSION 0.13.15

# Install sbt
RUN \
  curl -L -o sbt-$SBT_VERSION.deb http://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  sbt sbtVersion

EXPOSE 9000

CMD sbt run
