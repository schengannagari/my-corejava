package com.core.thread.concurrent;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorExample {
    public static void main(String[] args) {
        final int batchCount = 5;
        final int orders = 103;
        final int batchSize = orders / batchCount;
        int[] batches = new int[batchCount];
        int remainder = orders % batchCount;
        for (int i = 0; i < batchCount; i++) {
            if (i < remainder) {
                batches[i] = batchSize + 1;
            } else {
                batches[i] = batchSize;
            }
        }
        System.out.println(Arrays.toString(batches));
        try (ExecutorService executorService = Executors.newFixedThreadPool(batchSize)) {
            for (int batch : batches) {
                BatchJob batchJob = new BatchJob("Job " + batch);
                executorService.execute(batchJob);
            }
            executorService.shutdown();
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
