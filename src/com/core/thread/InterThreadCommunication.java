package com.core.thread;

public class InterThreadCommunication {
    public static void main(String[] args) {
        Util util = new Util();
        NumberThread numberThread = new NumberThread(util);
        Alphabets alphabets = new Alphabets(util);
        numberThread.start();
        alphabets.start();
    }
}

class Util {
    private boolean flag = false;
    synchronized public void displayNumber() {
        for (int i = 65; i < 91; i++) {
            System.out.print(i + "\t");
            flag = true;
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    synchronized public void displayAlphabet() {
        for (int i = 65; i < 91; i++) {
            if (!flag) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println((char)i);
            flag = false;
            this.notify();
        }
    }
}

class NumberThread extends Thread {
    private final Util util;
    public NumberThread(final Util util) {
        this.util = util;
    }

    public void run() {
        this.util.displayNumber();
    }
}

class Alphabets extends Thread {
    private final Util util;

    public Alphabets(final Util util) {
        this.util = util;
    }

    public void run() {
        this.util.displayAlphabet();
    }
}