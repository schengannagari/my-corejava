package com.core.thread;

public class VolatileVariable {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread workerThread = new Thread(() -> {
            while (!flag) {
                System.out.println("Worker thread is running");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Worker thread completed!");
        });

        workerThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Requesting worker thread to stop...");
        flag = true;
        try {
            workerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
