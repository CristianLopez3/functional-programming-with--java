package com.finance.programming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Usage of flatMap in Java 8 Streams")
public class UsageOfFlatMap {

    @Test
    @DisplayName("Flattening a 2D array using flatMap")
    void testFlattening2DArray() {
        int[][] twoDArray = {{1, 2}, {3, 4}, {5, 6}};
        int[] expectedArray = {1, 2, 3, 4, 5, 6};

        int[] oneDArray = Arrays.stream(twoDArray)
                        .flatMapToInt(Arrays::stream)
                        .toArray();

        assertArrayEquals(expectedArray, oneDArray);

    }

    @Test
    @DisplayName("Flattening a 2D array using flatMap")
    void testFlatteningAListOfInteger() {
        List<List<Integer>> twoDList = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );

        List<Integer> expectedList = List.of(1, 2, 3, 4, 5, 6);

        Function<List<Integer>, Stream<Integer>> returnJustOneList = Collection::stream;

        List<Integer> actualList = twoDList.stream()
                .flatMap(returnJustOneList::apply)
                .toList();

        assertIterableEquals(expectedList, actualList, () -> {
            System.out.println("Expected List:  " + expectedList);
            System.out.println("Actual List:  " + actualList);
            return "The content of the list doesn't match";
        });

    }

}
