package com.core.thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    public static void main(String[] args) {
        final Account account1 = new Account(10000);
        final Account account2 = new Account(10000);

        final Random random = new Random();

        final Lock lock1 = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    acquireLocks(lock1, lock2);
                    account1.transferAmount(account2, random.nextInt(100));
                } finally {
                    lock2.unlock();
                    lock1.unlock();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    acquireLocks(lock2, lock1);
                    account2.transferAmount(account1, random.nextInt(100));
                } finally {
                    lock2.unlock();
                    lock1.unlock();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Account1 balance:\t"+account1.getBalance());
        System.out.println("Account2 balance:\t"+account2.getBalance());
        System.out.println("Total balance:\t"+(account1.getBalance() + account2.getBalance()));
    }

    public static void acquireLocks(Lock lock1, Lock lock2) {
        boolean firstLockAquired;
        boolean secondLockAquired = false;
        while (true) {
            firstLockAquired = lock1.tryLock();

            if (firstLockAquired) {
                secondLockAquired = lock2.tryLock();
            }

            if (firstLockAquired && secondLockAquired) {
                return;
            }

            if (firstLockAquired) {
                lock1.unlock();
            }
        }
    }
}

class Account {

    private double balance;
    public Account(final double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(final double amount) {
        this.balance += amount;
    }

    public void withdraw(final double amount) {
        if (this.balance > amount) {
            this.balance -= amount;
        }
    }

    public void transferAmount(final Account account, final double amount) {
        if (this.getBalance() > amount) {
            this.withdraw(amount);
            account.deposit(amount);
        }
    }
}