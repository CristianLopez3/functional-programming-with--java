package com.finance.programming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("test Join a list of strings")
    void testJoinAListOfStrings(){
        // Convert a list of strings into a single comma-separated string using Collectors.joining.
        List<String> listOfString = List.of("Spring", "Microservices", "Boot", "Test");
        String  expectedString = "Spring,Microservices,Boot,Test";

//        String actualString = String.join(",", listOfString);
        String actualString = listOfString.stream()
                .collect(Collectors.joining(","));

        assertEquals(expectedString, actualString);
    }


    @Test
    @DisplayName(": Sort a list of strings in reverse alphabetical order using streams.")
    void testSortAListOfStrings(){
        List<String> listOfString = List.of("spa", "zar", "tool", "alp", "toy");
        List<String> expectedList = List.of("zar", "toy", "tool", "spa", "alp");
        List<String> actualList = listOfString.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        assertIterableEquals(expectedList, actualList, "The list doesn't match");

        assertNotEquals(
                expectedList,
                listOfString.stream().sorted(Comparator.naturalOrder()).toList(),
                "The list must not be equals"

        );
    }

}
