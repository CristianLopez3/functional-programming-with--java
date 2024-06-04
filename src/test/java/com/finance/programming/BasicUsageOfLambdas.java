package com.finance.programming;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@DisplayName("Tests for sum of two numbers")
public class BasicUsageOfLambdas {

    private static final int[] NUMBERS = {1, 2};
    private static final int EXPECTED_SUM = 3;
    private static final int NOT_EXPECTED_SUM = 5;

    @Test
    @DisplayName("Given two numbers, when summed, then should return correct sum")
    void testSumOfTwoNumbers(){

        int actualSum = Arrays.stream(NUMBERS).sum();

        assertEquals(EXPECTED_SUM, actualSum,
                "The sum of the numbers did not match the expected sum");
        assertNotEquals(NOT_EXPECTED_SUM, actualSum,
                "The sum of the numbers was not expected to be " + NOT_EXPECTED_SUM);
    }


}
