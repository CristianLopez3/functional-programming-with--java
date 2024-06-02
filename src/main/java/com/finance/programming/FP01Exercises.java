package com.finance.programming;

import java.util.List;

public class FP01Exercises {

	private static List<String> COURSES = List
			.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

	private static List<Integer> NUMBERS = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

	private static int MIN_LENGTH = 4;

	public static void main(String[] args) {
		printCubesOfOddNumbersInListFunctional(NUMBERS);
		printAllCourses();
		printCoursesLength();
		printCoursesWith("Spring");
		printLengthOfEachCourse();
	}

	private static void printAllCourses(){
		COURSES.stream()
				.forEach(System.out::println);
	}

	private static void printCoursesLength(){
		COURSES.stream()
				.map(course -> course + " " + course.length())
				.forEach(System.out::println);
	}


	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
				.filter(number -> number % 2 != 0)
				.forEach(System.out::println);
	}

	private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
				.filter(number -> number % 2 != 0)
				.map (number -> number * number * number)
				.forEach(System.out::println);
	}


	private static void printLengthOfEachCourse(){
		COURSES.stream()
				.map(course -> course.length() >= MIN_LENGTH)
				.forEach(System.out::println);
	}

	private static void printCoursesWith(String word){
		COURSES.stream()
				.filter(course -> course.contains(word))
				.forEach(System.out::println);
	}



}
