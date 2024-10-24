package com.core.basic.string;

import java.util.Collections;
import java.util.stream.Collectors;

public class Manager2 {
    public static void main(String[] args) {
        String str = "Welcome to Java";
        String substring1 = str.substring(11);
        System.out.println("substring:\t"+substring1);

        String reversedString = str.chars().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
        String reversed = str.chars().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {Collections.reverse(list); return String.join("", list);}));
        String reversedString1 = "Hello World".chars().mapToObj(ch -> String.valueOf((char)ch)).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {Collections.reverse(list); return String.join("", list);}));
        System.out.println("Reversed String1:\t"+reversedString1);
        System.out.println("Reversed String:\t"+reversedString);
        System.out.println("reversed:\t"+ reversed);
    }
}
