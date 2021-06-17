# Testcontainers playground

Testing rootless docker with testcontainers.

1. Install [rootless docker](https://docs.docker.com/engine/security/rootless/)
1. Start rootless docker: `systemctl --user start docker` or `dockerd-rootless.sh`
1. Run tests: `./mvnw test`
