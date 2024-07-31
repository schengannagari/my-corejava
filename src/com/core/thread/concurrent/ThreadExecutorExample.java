package com.core.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorExample {
    public static void main(String[] args) {
        final int batchSize = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(batchSize);
        for (int i = 0; i < 10; i++) {
            BatchJob batchJob = new BatchJob("Job "+i);
            executorService.execute(batchJob);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
        }
    }
}

class BatchJob implements Runnable {

    private final String name;

    public BatchJob(final String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(this.name + " is being processed by the "+ Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(this.name + " completed by the "+ Thread.currentThread().getName());
    }
}
