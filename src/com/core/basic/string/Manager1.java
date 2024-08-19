package com.core.basic.string;

public class Manager1 {
    public static void main(String[] args) {
        String str = "hello world";
        str.chars().mapToObj(c -> (char)c).forEach(System.out::print);
        System.out.println();
        str.chars().forEach(c -> System.out.print((char)c));
    }
}
