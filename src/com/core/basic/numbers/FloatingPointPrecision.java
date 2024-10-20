package com.core.basic.numbers;

import java.math.BigDecimal;

public class FloatingPointPrecision {
    public static void main(String[] args) {
        Double a = 0.1d;
        Double b = 0.2d;
        Double c = 0.3d;
        Double d = a + b;
        System.out.println(a + b == c);
        System.out.println(d.equals(c));

        BigDecimal ba = new BigDecimal("0.1");
        BigDecimal bb = new BigDecimal("0.2");

        BigDecimal bc = new BigDecimal("0.3");
        BigDecimal result = ba.multiply(new BigDecimal("3"));
        BigDecimal sum = ba.add(bb);

        System.out.println(sum.equals(bc));
        System.out.println(result.equals(bc));
    }
}
