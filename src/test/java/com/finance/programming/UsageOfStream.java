package com.finance.programming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class UsageOfStream {

    @Test
    @DisplayName("Given a list of numbers, when filter function is applied, then should return the even numbers")
    void creatingAnInfiniteStream(){
        int[] actualResult =  Stream.iterate(0, x -> x + 2)
                .limit(10)
                .mapToInt(Integer::intValue)
                .toArray();
        int[] expectedResult = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};


        assertArrayEquals(expectedResult, actualResult,
                "The array doesn't match");
    }

}
