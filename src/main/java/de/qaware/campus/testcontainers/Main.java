package de.qaware.campus.testcontainers;

public class Main {
    public static void main(String[] args) {
        // Run redis with:
        // docker run -p 6379:6379 redis

        Counter counter = new Counter("redis://localhost:6379/");
        counter.start();
        try {
            System.out.println(counter.increment());
            System.out.println(counter.increment());
            System.out.println(counter.increment());
            System.out.println(counter.increment());
            System.out.println(counter.increment());
        } finally {
            counter.stop();
        }
    }
}
