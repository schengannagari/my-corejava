package com.core.basic.numbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateNumbers {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(10, 3, 8, 2, 10, 3, 20, 12, 10, 8);
        Set<Integer> duplicatesNumList = integerList.stream().filter(num -> Collections.frequency(integerList, num) > 1).collect(Collectors.toSet());
        System.out.println("duplicatesNumList:\t"+duplicatesNumList);
    }
}
