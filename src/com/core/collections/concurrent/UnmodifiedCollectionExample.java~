package com.core.collections.concurrent;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UnmodifiedCollectionExample {
    public static void main(String[] args) {
        List<String> stringList = new CopyOnWriteArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        for (String string : stringList) {
            System.out.println(string);
            if (string.equals("A")) {
                stringList.add("D");
            }
        }
        System.out.println(stringList);

        Set<String> stringSet = new CopyOnWriteArraySet<>();
        stringSet.add("1");
        stringSet.add("2");
        stringSet.add("3");
        for (String string : stringSet) {
            System.out.println(string);
            if (string.equals("1")) {
                stringSet.add("4");
            }
        }
    }
}
