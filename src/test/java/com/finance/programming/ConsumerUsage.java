package com.finance.programming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

@DisplayName("TestConsumer")
public class ConsumerUsage {

    // Define a Consumer that takes a string and prints it in uppercase.

    private static final String EXPECT_STRING = "SPRINGBOOT";
    private static final String GIVEN_WORD = "springboot";

    @Test
    @DisplayName("Given a string, when consumer function applied, then should print the word in uppercase")
    void testWordToUppercase(){
        Consumer<String> consumer = word -> System.out.println(word.toUpperCase());
        consumer.accept(GIVEN_WORD);
    }

}
