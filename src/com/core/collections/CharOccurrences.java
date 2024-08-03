package com.core.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharOccurrences {
    public static void main(String[] args) {
        String str = "Hello World";

        //manual approach
        Map<String, Integer> manualGroupMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++ ) {
            String key = String.valueOf(str.charAt(i));
            if (manualGroupMap.containsKey(key)) {
                manualGroupMap.put(key, manualGroupMap.get(key) + 1);
            } else {
                manualGroupMap.put(key, 1);
            }
        }
        System.out.println("manual approach");
        System.out.println(manualGroupMap);


        // Grouping By
        Map<String, Long> groupMap = str.chars().mapToObj(c -> String.valueOf((char)c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("groupingBy approach");
        System.out.println(groupMap);

        // to Map approach
        Map<String, Long> map = str.chars().mapToObj(c -> String.valueOf((char)c))
                        .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
        System.out.println("toMap based approach");
        System.out.println(map);


        // Using Map's merge approach
        Map<String, Integer> mergeGroupMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++ ) {
            String key = String.valueOf(str.charAt(i));
            mergeGroupMap.merge(key, 1, Integer::sum);
        }
        System.out.println("Map merge method approach");
        System.out.println(mergeGroupMap);

        // Using Map's compute approach
        Map<String, Integer> computeGroupMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++ ) {
            String key = String.valueOf(str.charAt(i));
            computeGroupMap.compute(key, (k, v) -> null == v ? 1 : v + 1);
        }
        System.out.println("Map compute method approach");
        System.out.println(computeGroupMap);
    }
}
