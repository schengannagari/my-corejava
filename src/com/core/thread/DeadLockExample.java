package com.core.thread;

public class DeadLockExample {
    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Resource resource2 = new Resource();

        Thread thread1 = new Thread(() -> {
            synchronized(resource1) {
                System.out.println(Thread.currentThread().getName() +"\t acquired the lock on resource1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(resource2) {
                    System.out.println(Thread.currentThread().getName() +"\t acquired the lock on resource2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized(resource2) {
                System.out.println(Thread.currentThread().getName() +"\t acquired the lock on resource2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(resource1) {
                    System.out.println(Thread.currentThread().getName() +"\t acquired the lock on resource1");
                }
            }
        });

        thread1.start();
        thread2.start();

        System.out.println("Done!");

    }
}

class Resource {

}