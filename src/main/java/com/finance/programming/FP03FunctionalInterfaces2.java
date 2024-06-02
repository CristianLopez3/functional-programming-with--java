package com.finance.programming;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces2 {

	
	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		Predicate<Integer> evenPredicate = x -> x % 2 == 0;
		Predicate<Integer> oddPredicate = x -> x % 2 != 0;

//		filterAndPrint(numbers, evenPredicate);
		filterAndPrint(numbers, (x) -> x % 3 == 0);


		Function<Integer, Integer> mapper = x -> x * x;

		mapAndCreateList(numbers, mapper);

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
