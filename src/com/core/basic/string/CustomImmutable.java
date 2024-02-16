package com.core.basic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomImmutable {
    public static void main(String[] args) {
        Immutable immutable = new Immutable("Abc", Arrays.asList("Hello", "World"));
        System.out.println(immutable.getStringList());
    }
}

final class Immutable {
    private final String name;
    private final List<String> stringList;

    public Immutable(final String name, final List<String> stringList) {
        this.name = name;
        this.stringList = new ArrayList<>(stringList);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getStringList() {
        return Collections.unmodifiableList(this.stringList);
    }
}


