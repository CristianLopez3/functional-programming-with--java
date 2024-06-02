package com.finance.programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces2 {

    /**
     * IntBinaryOperator
     * IntConsumer
     * IntFunction
     * IntPredicate
     * IntSupplier
     * IntToDoubleFunction
     * IntToLongFunction
     */

    private static List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

	public static void main(String[] args) {
//        predicate();
//        consumer();
//        function();
//        binaryOperator();
//        unaryOperator(3);
//        biPredicate();
//	      biFunction();
//        biConsumer();
    }


    private static void biConsumer(){
        BiConsumer<String, String> biConsumer = (str1, str2) -> {
            System.out.println(str1);
            System.out.println(str2);
        };
        biConsumer.accept("Hello", "World!");
    }


    private static void biFunction(){
        BiFunction<Integer, Integer, String> biFunction = (x, y) -> String.format("""
            number 1: %d
            number 2: %d
        """, x, y);
        System.out.println(biFunction.apply(2, 3));
    }


    private static void biPredicate(){
        BiPredicate<Integer, String> biPredicate = (x, y) -> x <= y.length();
        System.out.println(biPredicate.test(5, "Hello World"));
    }


    private static void predicate(){
        Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        Predicate<Integer> oddPredicate = x -> x % 2 != 0;

        filterAndPrint(numbers, evenPredicate);
        filterAndPrint(numbers, (x) -> x % 3 == 0);
    }


    private static void consumer(){
        Consumer<Integer> sysoutInteger = System.out::println;
    }

    
    private static void function(){
        Function<Integer, Integer> mapper = x -> x * x;
        Function<Integer, String> stringMapper = x -> x + "";

        mapAndCreateList(numbers, mapper);
    }


    private static void binaryOperator(){
        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        System.out.println(randomIntegerSupplier.get());
    }


    private static void unaryOperator(int number){
        UnaryOperator<Integer> unaryOperator = x -> number * x;
        System.out.println(unaryOperator.apply(3));
    }


	private static void mapAndCreateList(List<Integer> numbers, Function<Integer, Integer> mapper) {
		numbers.stream()
				.map(mapper)
				.collect(Collectors.toList());
	}


	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
				.filter(predicate)
				.forEach(System.out::println);
	}



}
