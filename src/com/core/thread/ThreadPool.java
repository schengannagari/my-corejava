package com.core.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    public static void main(String[] args) {
        Pool pool = Pool.getPool();
        ResourceThread thread = pool.checkout();
        thread.start();
        boolean flag = pool.checkin(thread);
        if (flag) {
            System.out.println("Thread returned successfully!");
        }
    }
}

class ResourceThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class Pool {
    private final List<ResourceThread> threads = new ArrayList<>(10);
    private final static Pool pool = new Pool();
    private Pool() {
        for (int i = 0; i < 10; i++) {
            ResourceThread thread = new ResourceThread();
            threads.add(thread);
        }
    }

    public static Pool getPool() {
        return pool;
    }

    public ResourceThread checkout() {
        if (!threads.isEmpty()) {
            return threads.remove(0);
        }
        ResourceThread thread = new ResourceThread();
        threads.add(thread);
        return thread;
    }

    public boolean checkin(ResourceThread thread) {
        if (threads.size() < 10) {
            threads.add(thread);
            return true;
        }
        return false;
    }
}

