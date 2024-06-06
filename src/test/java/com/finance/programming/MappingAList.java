package com.finance.programming;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MappingAList {


    /**
     * Take a list of strings and use map to convert all strings to uppercase.
     */


    @Test
    void testStringToUpperCase(){
        List<String> givenList = List.of("Spring", "java", "microservices", "aws", "api", "kubernetes");
        List<String> expectedList = List.of("SPRING", "JAVA", "MICROSERVICES", "AWS", "API", "KUBERNETES");

        List<String> actualList = givenList.stream()
                .map(String::toUpperCase)
                .toList();

        assertIterableEquals(expectedList, actualList,
                "The lists does not match their contents");

        assertEquals(expectedList.get(1), actualList.get(1),
                "The content of the given index does not match");

        assertNotEquals(expectedList, givenList,
                "The list match its content, the content must not match");

        assertEquals(expectedList.size(), actualList.size(),
                "The size does not match");

    }

}
