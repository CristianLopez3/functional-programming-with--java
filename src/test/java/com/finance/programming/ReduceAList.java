package com.finance.programming;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class ReduceAList {

    /**
     *  Use reduce to sum all the elements of a list of integers.
     */

    @Test
    void testReduceToASumOfNumbers(){
        List<Integer> givenList = List.of(1, 2, 3, 4, 5);
        int expectedSum = 15;

        // BinaryOperator<Integer> findASum = (x, y) -> x + y;
        BinaryOperator<Integer> findASum = Integer::sum;


        int actualSum = givenList.stream()
                .reduce(findASum)
                .orElse(0);

        assertEquals(expectedSum, actualSum,
                "The result does not match");

        assertNotEquals(10, actualSum,
                "The result match, it must not be the same");

    }


}
