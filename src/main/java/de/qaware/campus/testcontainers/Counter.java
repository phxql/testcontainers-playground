package de.qaware.campus.testcontainers;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

public class Counter {
    private final String redisUrl;
    private StatefulRedisConnection<String, String> connection;
    private RedisClient redisClient;

    public Counter(String redisUrl) {
        this.redisUrl = redisUrl;
    }

    public void start() {
        redisClient = RedisClient.create(redisUrl);
        connection = redisClient.connect();
    }

    public void stop() {
        connection.close();
        connection = null;

        redisClient.shutdown();
        redisClient = null;
    }

    public long increment() {
        return connection.sync().incr("key");
    }
}
