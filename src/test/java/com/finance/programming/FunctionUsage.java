package com.finance.programming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Functions")
public class FunctionUsage {

    private static final int EXPECTED_LENGTH = 10;
    private static final String WORD = "Springboot";
    private static final String EMPTY_STRING = "";

    @Test
    @DisplayName("Given a string, when length function applied, then should return correct length")
    void testStringLengthFunction(){
        Function<String, Integer> findLength = String::length;

        int actualLength = findLength.apply(WORD);

        assertEquals(EXPECTED_LENGTH, actualLength,
                "The length of the word did not match the expected length");
    }

    @Test
    @DisplayName("Given an empty string, when length function applied, then should return zero")
    void testEmptyStringLengthFunction(){
        Function<String, Integer> findLength = String::length;

        int actualLength = findLength.apply(EMPTY_STRING);

        assertEquals(0, actualLength,
                "The length of an empty string should be zero");
    }

}
