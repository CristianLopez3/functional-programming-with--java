package com.finance.programming;

import java.awt.*;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class FP08EntrySet {

    /**
     * A Map contains key-value pairs. It is not a Collection. It is a collection of pairs.
     * Each pair is called an Entry. So a Map is a collection of Entry objects.
     * EntrySet is a set of Entry objects.
     * You can use a entry set to manipulate streams of key-value pairs.
     * @param args
     */

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);

        map.forEach((key, value) -> System.out.println(key + " " + value));

        Map<String, Long> map2 = map.entrySet()
                .stream()
                .distinct()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (long) entry.getValue()));

    }
}
