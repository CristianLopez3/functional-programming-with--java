package com.finance.programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {

	private static List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Predicate<Integer> filter = number -> number % 2 == 0;
		Predicate<Integer> filter2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer number) {
				return number % 2 == 0;
			}
		};

		Function<Integer, Integer> mapper = number -> number * number;
		Function<Integer, Integer> mapper2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer number) {
				return number * number;
			}
		};

		Consumer<Integer> consumer = System.out::println;
		Consumer<Integer> consumer2 = new Consumer<Integer>() {
			@Override
			public void accept(Integer integer) {
				System.out.println(integer);
			}
		};

		numbers.stream()
				.filter(filter2)
				.map(mapper2)
				.forEach(consumer2);


		BinaryOperator<Integer> reducer = Integer::sum;
		BinaryOperator<Integer> reducer2 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer a, Integer b) {
				return a + b;
			}
		};
		int sum = numbers.stream().reduce(0, reducer2);

	}

}
