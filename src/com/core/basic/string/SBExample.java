package com.core.basic.string;

public class SBExample {
    private static final String str = "Java";
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(str);
        StringBuffer buffer = new StringBuffer(str);
        System.out.println("StringBuilder:\t"+ sb);
        System.out.println("StringBuffer:\t"+ buffer);
        System.out.println("-----------------------------------------------------");
        System.out.println("StringBuilder is equals to String:\t"+ sb.equals(str));
        System.out.println("String is equals to StringBuilder:\t"+ str.equals(sb));
        System.out.println("String and StringBuilder content comparison:\t"+ str.contentEquals(sb));
        System.out.println("-----------------------------------------------------");
        System.out.println("StringBuffer is equals to String:\t"+ buffer.equals(str));
        System.out.println("String is equals to StringBuffer:\t"+ str.equals(buffer));
        System.out.println("String and StringBuffer content comparison:\t"+ str.contentEquals(buffer));
    }
}
