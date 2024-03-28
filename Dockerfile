FROM ubuntu:24.04

# RUN apt-get -y update && apt-get -y upgrade
COPY target/springboot-mysql /

CMD ["/springboot-mysql"]
