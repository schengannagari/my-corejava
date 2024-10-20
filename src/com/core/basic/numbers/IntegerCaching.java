package com.core.basic.numbers;

/**
 * The Java caches integer objects for values in a specified range of -128 to 127
 * to avoid repeatedly creating new object for the commonly used numbers.
 * -
 * By default, this range is -128 - 127. This means that when you auto box
 * an int value within this range, instead of creating a new Integer object, Java will reuse the one from the cache.
 * -
 * How the Cache Range Can Be Changed:
 * You can modify the upper bound of the cache by setting the system property java.lang.Integer.IntegerCache.high when
 * running your application. For example:
 * -
 * java.lang.Integer.IntegerCache.high=1000, by this way you can change the cache range to -128 to 1000.
 */
public class IntegerCaching {
    public static void main(String[] args) {
        Integer i = -128;
        Integer j = -128;
        System.out.println(i == j);

        Integer o = -129;
        Integer p = -129;
        System.out.println(o == p);

        Integer k = 127;
        Integer l = 127;
        System.out.println(k == l);

        Integer m = 128;
        Integer n = 128;
        System.out.println(m == n);


    }
}
