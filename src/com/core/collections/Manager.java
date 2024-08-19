package com.core.collections;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    public static void main(String[] args) {
        Map<MyClass, String> myClassStringMap = new HashMap<>();
        myClassStringMap.put(new MyClass("ABC"), "ABC");
        myClassStringMap.put(new MyClass("XYZ"), "XYZ");
        myClassStringMap.put(new MyClass("ABC"), "ABC");
        myClassStringMap.put(new MyClass("PQR"), "PQR");

        System.out.println(myClassStringMap);
    }
}

class MyClass {
    private String name;

    public MyClass(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(final Object object) {

        if (this == object) {
            return true;
        }

        MyClass myClass = (MyClass) object;
        return this.name.equals(myClass.name);
    }

    public String toString() {
        return this.name;
    }
}
