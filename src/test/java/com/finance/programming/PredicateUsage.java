package com.finance.programming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Predicate")
public class PredicateUsage {

    private static final boolean EXPECTED_EVEN = true;
    private static final int EVEN_NUMBER = 10;
    private static final boolean EXPECTED_ODD = false;
    private static final int ODD_NUMBER = 9;
    private static final int ZERO = 0;

    @Test
    @DisplayName("Given an even number, when even number predicate is applied, then should return true")
    void testEvenNumberPredicate(){
        Predicate<Integer> isEven = x -> x % 2 == 0;
        boolean actualResult = isEven.test(EVEN_NUMBER);

        assertEquals(EXPECTED_EVEN, actualResult,
                "The number was expected to be even");
    }

    @Test
    @DisplayName("Given an odd number, when even number predicate is applied, then should return false")
    void testOddNumberPredicate(){
        Predicate<Integer> isEven = x -> x % 2 == 0;
        boolean actualResult = isEven.test(ODD_NUMBER);

        assertEquals(EXPECTED_ODD, actualResult,
                "The number was not expected to be even");
    }

    @Test
    @DisplayName("Given zero, when even number predicate is applied, then should return true")
    void testZeroNumberPredicate(){
        Predicate<Integer> isEven = x -> x % 2 == 0;
        boolean actualResult = isEven.test(ZERO);

        assertEquals(EXPECTED_EVEN, actualResult,
                "Zero was expected to be even");
    }

}
