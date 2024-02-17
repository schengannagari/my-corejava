package com.core.thread;

public class VolatileExample {
    static volatile boolean flag = true;
    public static void main(String[] args) {
        new Thread(() -> {
            while (flag) {
                System.out.println("Running:\t" + Thread.currentThread().getName());
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "First-Thread").start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            flag = false;
        }, "Second-Thread").start();
    }
}

class Flag {
    public boolean flag = true;
}