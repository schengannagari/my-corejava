package com.core.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureExamples {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(CompletableFutureExamples::getList).thenApply(CompletableFutureExamples::upperCase).thenAccept(System.out::println);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(CompletableFutureExamples::getList).thenApply(CompletableFutureExamples::upperCase);
        System.out.println("Done!");
        try {
            String string = completableFuture.get();
            System.out.println("string:\t"+string);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getList() {
        List<String> stringList = new ArrayList<>();

        stringList.add("Abc");
        stringList.add("Xyz");
        stringList.add("Hello");
        stringList.add("world");

        return stringList;
    }

    public static String upperCase(final List<String> stringList) {
        System.out.println("inside the uppercase method");
        return stringList.stream().map(String::toUpperCase).collect(Collectors.joining(","));
    }
}
