package com.core.basic.numbers;

import java.util.Arrays;
import java.util.List;

public class AutoBoxingUnBoxing {
    public static void main(String[] args) {
        List<Integer> integersList = Arrays.asList(1, 2, 3, 4, 5);
        int max = integersList.stream().max(Integer::compareTo).orElse(0);
        System.out.println("Max:\t"+max);

        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5");
        System.out.println("Max:\t"+stringList.stream().map(Integer::valueOf).max(Integer::compareTo).orElse(0));

    }
}
