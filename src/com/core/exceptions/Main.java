package com.core.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
    // Parent constructor throws FileNotFoundException
    public Parent() throws FileNotFoundException {
        System.out.println("Parent constructor");
        throw new FileNotFoundException("Parent exception");
    }
}

class Child extends Parent {
    // Error: Child cannot throw broader exception like IOException
    // public Child() throws IOException {
    //     super();
    // }

    // Correct: Child can throw the same exception or a narrower one
    public Child() throws IOException {
        super();
        System.out.println("Child constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Parent obj = new Child(); // Allowed: Must handle FileNotFoundException
        } catch (IOException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}

