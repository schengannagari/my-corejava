package com.core.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadBatchProcess {

    public static void main(String[] args) {
        List<String> stringList = createSampleList();
        int batchSize = 3;
        List<List<String>> batches = divideIntoBatches(stringList, batchSize);

        ExecutorService service = Executors.newFixedThreadPool(batchSize);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (List<String> batch : batches) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println(batch.size()),service);
            futures.add(future);
        }

        CompletableFuture<Void> allOff = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allOff.get();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }

        service.shutdown();

    }
    public static List<String> createSampleList() {
        List<String> stringList = new ArrayList<>(10);
        for (int i = 0; i < 20; i++) {
            stringList.add("Thread-"+i);
        }
        return stringList;
    }

    public static List<List<String>> divideIntoBatches(final List<String> stringList, final int batchSize) {
        int size = stringList.size();
        List<List<String>> batches = new ArrayList<>();
        for (int i = 0; i < size; i+= batchSize) {
            int endIndex = Math.min(i + batchSize, size);
            List<String> batch = stringList.subList(i, endIndex);
            batches.add(batch);
        }
        return batches;
    }
}

