package com.core.basic.string;

public class Manager {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        String str4 = new String("hello").intern();
        String str5 = str1 + " world";
        String str6 = "hello world";
        String str7 = String.join(" ", "hello",  "world");

        System.out.print("Is both str1 and str2 are same?");
        if (str1 == str2) {
            System.out.println("\tYes");
        } else {
            System.out.println("\tNo");
        }

        System.out.print("Is both str2 and str3 are same?");
        if (str2 == str3) {
            System.out.println("\tYes");
        } else {
            System.out.println("\tNo");
        }

        System.out.print("Is both str1 and str4 are same?");
        if (str2 == str4) {
            System.out.println("\tYes");
        } else {
            System.out.println("\tNo");
        }

        System.out.print("Is both str5 and str6 are same?");
        if (str5 == str6) {
            System.out.println("\tYes");
        } else {
            System.out.println("\tNo");
        }

        System.out.print("Is both str6 and str7 are same?");
        if (str7 == str6) {
            System.out.println("\tYes");
        } else {
            System.out.println("\tNo");
        }
    }
}
