package com.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Semaphore {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                Connection.getConnection().connect();
            });
        }
        executor.shutdown();
        try {
            boolean flag = executor.awaitTermination(1, TimeUnit.HOURS);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

class Connection {

    private int count;

    private final java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(1);
    private static final Connection connection = new Connection();
    private Connection() {

    }

    public static Connection getConnection() {
        return connection;
    }

    public void connect() {
        try {
           semaphore.acquire();
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName());
        count++;
        System.out.println("Current count:\t"+count);
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        count--;
        semaphore.release();
    }
}
