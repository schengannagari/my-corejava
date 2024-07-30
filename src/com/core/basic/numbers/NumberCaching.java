package com.core.basic.numbers;

public class NumberCaching {
    public static void main(String[] args) {
        Integer val1 = 127;
        Integer val2 = 127;

        Integer val3 = 150;
        Integer val4 = 150;

        Integer val5 = -127;
        Integer val6 = -127;

        Integer val7 = -150;
        Integer val8 = -150;

        if (val1 == val2)
            System.out.println("val1 == val2");
        else
            System.out.println("val1 != val2");

        if (val3 == val4)
            System.out.println("val3 == val4");
        else
            System.out.println("val3 != val4");

        if (val5 == val6)
            System.out.println("val5 == val6");
        else
            System.out.println("val5 != val6");

        if (val7 == val8)
            System.out.println("val7 == val8");
        else
            System.out.println("val7 != val8");
    }
}
