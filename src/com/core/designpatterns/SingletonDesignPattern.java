package com.core.designpatterns;

public class SingletonDesignPattern {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SingletonClass singletonClass = SingletonClass.getInstance();
            System.out.println(singletonClass);
        }
    }
}

class SingletonClass {
    private static volatile SingletonClass SINGLETON_CLASS;

    private SingletonClass() {

    }

    public static SingletonClass getInstance() {
        if (null != SINGLETON_CLASS) return SINGLETON_CLASS;
        synchronized (SingletonClass.class) {
            SINGLETON_CLASS = new SingletonClass();
        }
        return SINGLETON_CLASS;
    }
}
