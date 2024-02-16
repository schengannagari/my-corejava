package com.core.basic.string;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String str = "welcome";
        StringBuilder reverseString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseString.append(str.charAt(i));
        }
        System.out.println("Actual String:\t"+str);
        System.out.println("Reversed String:\t"+reverseString);
        String[] arr = str.split("");
        int mid = arr.length / 2;
        for (int i = 0; i < mid; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - (i+1)];
            arr[arr.length - (i+1)] = temp;
        }
        System.out.println("Reversed String:\t"+String.join("", arr));
    }
}
