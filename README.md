# Testcontainers playground

Testing rootless docker with testcontainers.

1. Install [rootless docker](https://docs.docker.com/engine/security/rootless/)
1. Start rootless docker: `systemctl --user start docker` or `dockerd-rootless.sh`
1. Run tests: `./mvnw test`

## Findings

* Testcontainers works with rootless-docker
* Rootless docker in a docker image
  needs `--privileged`: [See here](https://docs.docker.com/engine/security/rootless/#rootless-docker-in-docker)
* Sysbox [supports running docker in docker](https://blog.nestybox.com/2019/09/13/system-containers.html)
  without `--privileged`
