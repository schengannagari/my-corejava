package com.core.functional;

import java.util.function.*;

public class PredicateExamples {
    public static void main(String[] args) {
        Predicate<String> stringPredicate = String::isEmpty;

        Function<String, Boolean> stringBooleanFunction = String::isEmpty;

        Function<PredicateExamples, String> test = PredicateExamples::greet;

        BiFunction<PredicateExamples, Integer, String> biFunction = PredicateExamples::myString;

        System.out.println(stringPredicate.test(""));
        System.out.println(stringBooleanFunction.apply("Abc"));
        System.out.println(test.apply(new PredicateExamples()));
        System.out.println(biFunction.apply(new PredicateExamples(),1));

    }

    public String greet() {
        return "Hello";
    }

    public String myString(Integer i) {
        return "str".substring(i);
    }
}
