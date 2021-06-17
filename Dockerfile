# This is WIP

FROM adoptopenjdk:16

RUN apt update && apt install -y uidmap iptables kmod iproute2
RUN useradd -ms /bin/bash user

USER user
WORKDIR /home/user

RUN curl -fsSL https://get.docker.com/rootless | sh

ENV XDG_RUNTIME_DIR=/home/user/.docker/run
ENV PATH=/home/user/bin:$PATH
ENV DOCKER_HOST=unix:///home/user/.docker/run/docker.sock
