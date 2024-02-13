package com.core.basic.string;

public class Manager3 {
    public static void main(String[] args) {
        String str = "ABC";
        combinations(str, "");
    }

    public static void combinations(String str, String prefix) {
        if (str.isEmpty()) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            combinations(str.substring(0, i) + str.substring(i+1), str.charAt(i) + prefix);
        }
    }
}
