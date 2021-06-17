package de.qaware.campus.testcontainers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
public class CounterTest {
    @Container
    public GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis:latest")).withExposedPorts(6379);

    private Counter sut;

    @BeforeEach
    void setUp() {
        String host = redis.getHost();
        int port = redis.getFirstMappedPort();
        String uri = String.format("redis://%s:%d/0", host, port);

        sut = new Counter(uri);
        sut.start();
    }

    @AfterEach
    void tearDown() {
        sut.stop();
    }

    @Test
    void test() {
        assertThat(sut.increment()).isEqualTo(1);
        assertThat(sut.increment()).isEqualTo(2);
        assertThat(sut.increment()).isEqualTo(3);
    }
}