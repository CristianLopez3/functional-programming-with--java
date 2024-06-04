package com.finance.programming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Working with lists")
public class ListExercises {

    // Filter a list of integers to keep only the even numbers using streams and Predicate.

    @Test
    @DisplayName("Given a list of numbers, when filter function is applied, then should return the even numbers")
    void testListOfEvenNumbers(){

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> evenNumbers = List.of(2, 4, 6, 8);

        Predicate<Integer> filterEventNumbers = number -> number % 2 == 0;

        List<Integer> actualEvenNumbers = numbers.stream()
                .filter(filterEventNumbers)
                .toList();

        assertEquals(evenNumbers, actualEvenNumbers);


    }


}
