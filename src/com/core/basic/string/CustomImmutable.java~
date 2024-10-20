package com.core.basic.string;

import java.util.*;

public class CustomImmutable {
    public static void main(String[] args) {
        Immutable immutable1 = Immutable.of("Abc", Arrays.asList("Hello", "World"));
        Immutable immutable2 = Immutable.of("Abc", Arrays.asList("Hello", "World"));
        Immutable immutable3 = Immutable.of("Abcd", Arrays.asList("Hello", "World"));
        System.out.println(immutable1.hashCode());
        System.out.println(immutable2.hashCode());
        System.out.println(immutable3.hashCode());
    }
}

final class Immutable {
    private final String name;
    private final List<String> stringList;
    private static final Map<Immutable, Immutable> cache = new HashMap<>();

    public static Immutable of(final String name, final List<String> stringList) {
        if (!cache.isEmpty()) {
            Optional<Map.Entry<Immutable, Immutable>> immutableImmutableEntry1 = cache.entrySet().stream().findAny().filter(immutableImmutableEntry ->
                    Objects.equals(name, immutableImmutableEntry.getKey().getName()) &&
                            new HashSet<>(immutableImmutableEntry.getValue().getStringList()).containsAll(stringList));
            return immutableImmutableEntry1.map(Map.Entry::getValue).orElseGet(() -> {
                Immutable immutableImmutable = new Immutable(name, stringList);
                cache.put(immutableImmutable, immutableImmutable);
                return immutableImmutable;
            });
        } else {
            Immutable immutableImmutable = new Immutable(name, stringList);
            cache.put(immutableImmutable, immutableImmutable);
            return immutableImmutable;
        }
    }


    private Immutable(final String name, final List<String> stringList) {
        this.name = name;
        this.stringList = new ArrayList<>(stringList);
    }

    private boolean isExists(final String name, final List<String> stringList) {
        return this.name.contains(name) && isSameStringList(stringList);
    }

    private boolean isSameStringList(final List<String> stringList) {
        return new HashSet<>(stringList).containsAll(this.stringList);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getStringList() {
        return Collections.unmodifiableList(this.stringList);
    }

    public int hashcode(final String name, final List<String> stringList) {
        return Objects.hash(name, stringList);
    }

    public boolean equals(final Immutable immutable) {
        if (this == immutable) {
            return true;
        }

        return Objects.equals(name, immutable.name) && Objects.equals(stringList, immutable.stringList);

    }
}


