package com.core.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceExample {
    public static void main(String[] args) {
        final Counter counter = new Counter();
        CounterThread thread1 = new CounterThread(counter);
        CounterThread thread2 = new CounterThread(counter);
        CounterThread thread3 = new CounterThread(counter);
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final count:\t"+ counter.getCount());
    }
}

class Counter {
    int count;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        try {
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return this.count;
    }
}

class CounterThread extends Thread {
    private final Counter counter;
    public CounterThread(final Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            this.counter.increment();
        }
    }
}
