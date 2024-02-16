package com.core.thread;

public class MyThread extends Thread {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        System.out.println("New\t"+t.getState());
        t.start();
        String state;
        do {
            state = t.getState().name();
            if ("TIMED_WAITING".equals(state)) {
                System.out.println(t.getState());
                break;
            }
        } while (!"TERMINATED".equals(state));
        try {
          t.join();
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Terminated:\t"+t.getState());
        }
    }

    public void run() {
        System.out.println("Running:\t"+Thread.currentThread().getState());
        synchronized(this) {
            try {
                wait(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
