package com.core.thread;

import java.util.concurrent.*;

public class FutureThreadExample {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(myCallable);
        service.shutdown();
        if (future.isDone()) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class MyCallable implements Callable<String> {

    public String call() {
        System.out.println(Thread.currentThread().getName());
        return "I am from callable";
    }

}