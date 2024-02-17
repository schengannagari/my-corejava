package com.core.collections;

import java.util.LinkedList;

public class LinkedListExamples {
    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("100");
        stringLinkedList.add("200");
        stringLinkedList.add("300");
        stringLinkedList.add("400");
        stringLinkedList.add("500");

        stringLinkedList.offer("101");
        stringLinkedList.offerFirst("99");
        stringLinkedList.offerLast("600");
        System.out.println("stringLinkedList:\t"+stringLinkedList);
        String popString = stringLinkedList.pop();
        System.out.println("popString:\t"+ popString);
        System.out.println("After pop:\t"+stringLinkedList);
        stringLinkedList.push("98");
        System.out.println("peek:\t"+stringLinkedList.peek());
        System.out.println("After push 98:\t"+stringLinkedList);
        System.out.println(stringLinkedList.peek());
        System.out.println("poll:\t"+stringLinkedList.poll());
        System.out.println("After poll:\t"+stringLinkedList);
    }
}
