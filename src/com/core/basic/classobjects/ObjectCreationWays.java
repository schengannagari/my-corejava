package com.core.basic.classobjects;

import java.lang.reflect.InvocationTargetException;

public class ObjectCreationWays {

    public static void main(String[] args) {
        ObjectCreationWays objectCreationWays = new ObjectCreationWays();
        objectCreationWays.display();
        try {
            Class<?> c = Class.forName("com.core.basic.classobjects.ObjectCreationWays");
            ObjectCreationWays objectCreationWays1 = (ObjectCreationWays)c.getDeclaredConstructor().newInstance();
            objectCreationWays1.display();
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
    }

    public void display() {
        System.out.println("Hello World!");
    }
}
