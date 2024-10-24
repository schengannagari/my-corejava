package com.core.basic.numbers;

public class ArraysExamples {

    public static void main(String[] args) {
        //int[] arr = new int[3]{1, 2, 3}; -- Specifying both the size and values results in a compilation error.
        int[][] mul = new int[5][];
        mul[0] = new int[1];
        mul[1] = new int[2];
        mul[2] = new int[3];
        mul[3] = new int[4];
        mul[4] = new int[5];
        int count = 0; // initializing count
        for (int i = 0; i < mul.length; i++) {
            for (int j = 0; j < mul[i].length; j++) {
                mul[i][j] = count++;
            }
        }

        for (int[] value : mul) {
            for (int i : value) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        String[][] strs = new String[5][];
        strs[0] = new String[1];
        strs[1] = new String[2];
        strs[2] = new String[3];
        strs[3] = new String[4];
        strs[4] = new String[5];

        for (String[] str : strs) {
            for (int j = 0; j < str.length; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i = strs.length - 1; i >= 0; i--) {
            for (int j = 0 ; j < strs[i].length; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        int[][] arr = new int[3][];
        arr[0] = new int[3];
        arr[1] = new int[3];
        arr[2] = new int[3];
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + j;
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
