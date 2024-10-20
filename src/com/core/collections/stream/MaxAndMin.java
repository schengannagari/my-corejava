package com.core.collections.stream;

import java.util.*;
import java.util.stream.Collectors;

public class MaxAndMin {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(-20);
        integers.add(10);
        integers.add(30);
        integers.add(1);
        integers.add(-10);
        int max1 = integers.stream().mapToInt(Integer::intValue).max().orElse(0);
        int max2 = integers.stream().max((a, b) -> a >= b ? 1 : -1).orElse(0);
        int max3 = integers.stream().max(Integer::compareTo).orElse(0);
        int max4 = integers.stream().max(Comparator.naturalOrder()).orElse(0);
        int max5 = integers.stream().reduce(Integer::max).orElse(0);
        int max6 = integers.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::max));
        int max7 = integers.stream().collect(Collectors.collectingAndThen(Collectors.reducing(Integer::max), maxNum -> maxNum.orElse(0)));
        int max8 = Collections.max(integers);
        System.out.println("max1\t" + max1 + "\tmax2\t" + max2 + "\tmax3\t" + max3 +"\tmax4\t" + max4 + "\tmax5\t" + max5
                + "\tmax6\t" + max6 + "\tmax7\t" + max7 + "\tmax8\t"+ max8);

        int min = integers.stream().min((a, b) -> a >= b ? 1: -1).orElse(0);
        System.out.println(min);

        String reverse = "hello".chars().mapToObj(Character::toString).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
           Collections.reverse(list);
           return String.join("", list);
        }));

        System.out.println(reverse);
    }
}
