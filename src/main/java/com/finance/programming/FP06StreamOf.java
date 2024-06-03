package com.finance.programming;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FP06StreamOf {


    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 10).sum());

        System.out.println(IntStream.iterate(1, e -> e + 2).limit(10));

        System.out.println(IntStream
                .iterate(1, e -> e + 2)
                .limit(10)
                .peek(System.out::println)
                .sum()
        );

        IntStream
                .iterate(2, e -> e + 2)
                .limit(10)
                .peek(System.out::println)
                .sum();

        IntStream
                .iterate(2, e -> e * 2)
                .limit(10)
                .peek(System.out::println)
                .sum();

        System.out.println(IntStream
                .iterate(2, e -> e + 2)
                .limit(10)
                .boxed()
                .toList());


        System.out.println(LongStream
                .rangeClosed(1, 10)
                .mapToObj(BigDecimal::valueOf)
                .reduce(BigDecimal.ONE, BigDecimal::multiply));


    }

}
