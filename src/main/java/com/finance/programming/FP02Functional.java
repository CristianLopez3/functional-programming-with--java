package com.finance.programming;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

	/**
	 * reduce
	 * distinct
	 * sorted
	 * Comparing -> Comparators
	 * collect
	 */

	private static List<String> courses = List
			.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

	private static List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);


	public static void main(String[] args) {

//		int result = addListNumber(numbers);
//		int result = squareNumbersAndReturnTheSum(numbers);
//		int result = cubeNumbersAndReturnTheSum(numbers);
//		int result = findSumOfOddNumbersInAList(numbers);
//		System.out.println(result);

//		removeRepetitiveValues(numbers).forEach(System.out::println);
//		sortList(numbers).forEach(System.out::println);
//		convertListOfIntegersToDouble(numbers).forEach(System.out::println);

//		sortCoursesWith(courses).forEach(System.out::println);
		convertStringListToLength(courses).forEach(System.out::println);


	}

	public static int sum(int a, int b){
		return a + b;
	}

	private static int addListNumber(List<Integer> numbers){
		return numbers
				.stream()
				.reduce(0, (x, y) -> x + y);
				// .reduce(0, FP02Functional::sum);
				// .reduce(0, Integer::sum);
	}

	private static int squareNumbersAndReturnTheSum(List<Integer> numbers){
		return numbers
				.stream()
				.map(number -> number * number)
				.reduce(0, Integer::sum);
	}

	private static int cubeNumbersAndReturnTheSum(List<Integer> numbers){
		return numbers
				.stream()
				.map(number -> (int) Math.pow(number, 3))
				.reduce(0, Integer::sum);
	}

	private static int findSumOfOddNumbersInAList(List<Integer> numbers){
		return numbers
				.stream()
				.filter(number -> number % 2 == 1)
				.reduce(0, Integer::sum);
	}

	private static List<Integer> removeRepetitiveValues(List<Integer> numbers) {
		return numbers
				.stream()
				.distinct()
				.collect(Collectors.toList());
	}

	private static List<Integer> sortList(List<Integer> numbers){
		return numbers
				.stream()
				.sorted()
				.collect(Collectors.toList());
	}

	private static List<String> sortCoursesWith(List<String> courses){
		return courses
				.stream()
//				.sorted(Comparator.naturalOrder())
//				.sorted(Comparator.reverseOrder())
				.sorted(Comparator.comparing(str -> str.length()))
				.collect(Collectors.toList());
	}

	private static List<Double> convertListOfIntegersToDouble(List<Integer> numbers) {
		return numbers
				.stream()
				.map(Integer::doubleValue)
				.collect(Collectors.toList());
	}

	private static List<Integer> convertStringListToLength(List<String> courses){
		return courses
				.stream()
				.map(course -> course.length())
				.collect(Collectors.toList());
	}


}
