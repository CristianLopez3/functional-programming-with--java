package com.finance.programming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Supplier Usage")
public class SupplierUsage {

    private static final int EXPECTED_LENGTH = 10;

    @Test
    @DisplayName("Given a string, when supplier function is called, should return a random string with a length of 10")
    void testRandomWord() {
        Predicate<Integer> filterAlphabet = number -> (number <= 57 || number >= 65) && (number <= 90 || number >= 97);

        Supplier<String> randomStringSupplier = () -> {
            Random random = new Random();
            return IntStream
                    .range(57, 122)
                    .filter(filterAlphabet::test)
                    .limit(10)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        };

        String randomString = randomStringSupplier.get();
        assertEquals(EXPECTED_LENGTH, randomString.length(),
                String.format("The lest must be of %d characters", EXPECTED_LENGTH));
        System.out.println(randomString);
    }


}
