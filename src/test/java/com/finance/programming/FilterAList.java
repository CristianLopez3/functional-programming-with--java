package com.finance.programming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class FilterAList {

    /**
     *  Filtering a list Description: Filter a list of integers to keep only the even numbers using streams and Predicate.
     */

    @Test
    @DisplayName("Test Even Numbers Filter")
    void testEvenNumbers(){
        List<Integer> givenNumbers = List.of(1, 3, 4, 10, 20, 23, 15, 17, 19, 402);
        List<Integer> expectedNumbers = List.of(4, 10, 20, 402);

        Predicate<Integer> filterEvenNumbers = number -> number % 2 == 0;

        List<Integer> actualNumbers = givenNumbers.stream()
                .filter(filterEvenNumbers)
                .toList();

        assertIterableEquals(expectedNumbers, actualNumbers,
                "The content of the arrays is not the same");

        assertEquals(expectedNumbers.size(), actualNumbers.size(),
                "The size of the arrays does not match");

    }


}
