package com.core.basic.numbers;

public class Conversion {

    public static void main(String[] args) {
        float f = 0.1f;
        double d = 0.2d;
        double sum = f + d;
        System.out.println(sum);

        byte b = 1;
        byte sum1 = (byte)(126 + b);
        System.out.println(sum1);

        char c = 64;
        char sum2 = (char)(c + 1);
        System.out.println(c + 1);
        System.out.println(sum2);

        char c1 = 'A';
        System.out.println("Abc".charAt(0) + 1);
        char sum3 = (char)(c1 + 1);
        System.out.println(c1 + 1);
        System.out.println(sum3);
    }
}
