package com.finance.programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

}

class Category {
    public static String FRAMEWORK = "Framework";
    public static String CLOUD = "Cloud";
    public static String FULL_STACK = "Full stack";
}

public class FP04CustomClass {


    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", Category.FRAMEWORK, 98, 20000),
                new Course("Spring Boot", Category.FRAMEWORK, 97, 20000),
                new Course("Hibernate", Category.FRAMEWORK, 38, 15000),
                new Course("AWS", Category.CLOUD, 38, 8000),
                new Course("Docker", Category.CLOUD, 28, 7000),
                new Course("Kubernetes", Category.CLOUD, 198, 3000),
                new Course("Fullstack", Category.FULL_STACK, 18, 19000)
        );

        /**
         * allMatch, noneMatch, anyMatch
         */

        reviewIfAllTheCoursesHaveAScoreGreaterThan(courses, 0);
        sortCourses(courses);
        limitCourses(courses);
        skipCourses(courses);
        getCourses(courses);
        takeWhile(courses);
        dropWhile(courses);
        maxCourse(courses);
        minCourse(courses);
        findFirst(courses);
        findAny(courses);
        average(courses);
        mapToHash(courses);

    }


    public static void mapToHash(List<Course> courses) {
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println(courses.stream()
                 .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList()))));
    }


    public static void average(List<Course> courses) {
        Predicate<Course> reviewScoreGreaterThan = course -> course.getReviewScore() > 90;

        System.out.println("Sum: " + courses.stream()
                .filter(reviewScoreGreaterThan)
                .mapToInt(Course::getNoOfStudents)
                .sum());

        System.out.println("Average: " + courses.stream()
                .filter(reviewScoreGreaterThan)
                .mapToInt(Course::getNoOfStudents)
                .average());

        System.out.println("Maximun value" + courses.stream()
                .filter(reviewScoreGreaterThan)
                .mapToInt(Course::getNoOfStudents)
                .max());

    }


    public static void reviewIfAllTheCoursesHaveAScoreGreaterThan(List<Course> courses, int score) {
        Predicate<Course> reviewScoreGreaterThan = course -> course.getReviewScore() > score;
        System.out.println(
                courses.stream()
                        .noneMatch(reviewScoreGreaterThan)
        );
        System.out.println(
                courses.stream()
                        .allMatch(reviewScoreGreaterThan)
        );
        System.out.println(
                courses.stream()
                        .anyMatch(reviewScoreGreaterThan)
        );
    }


    public static void sortCourses(List<Course> courses) {
        Comparator<Course> comparingByNoOfStudents = Comparator.comparingInt(Course::getNoOfStudents);
        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator
                .comparingInt(Course::getNoOfStudents).reversed();

        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator
                .comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore);


        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsIncreasing)
                        .toList()
        );
    }


    public static void limitCourses(List<Course> courses) {
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator
                .comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore);

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .limit(5)
                        .toList()
        );
    }


    public static void skipCourses(List<Course> courses) {
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator
                .comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore);

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .skip(4)
                        .toList()
        );
    }


    public static void getCourses(List<Course> courses) {
        courses.forEach(System.out::println);
    }


    public static void takeWhile(List<Course> courses) {
        System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewScore() > 90)
                .toList()
        );
    }


    public static void dropWhile(List<Course> courses) {
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore() > 90)
                .toList()
        );
    }


    public static void maxCourse(List<Course> courses) {
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator
                .comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore);
        System.out.println(
                courses.stream()
                        .max(comparingByNoOfStudentsAndNoOfReviews)
        );
    }


    public static void minCourse(List<Course> courses) {
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator
                .comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore);
        System.out.println(
                courses.stream()
                        .min(comparingByNoOfStudentsAndNoOfReviews)
                        .orElse(new Course("AWS", Category.CLOUD, 38, 8000))
        );
    }


    public static void findFirst(List<Course> courses) {
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator
                .comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore);
        System.out.println(
                courses.stream()
                        .filter((Predicate<Course>) comparingByNoOfStudentsAndNoOfReviews)
                        .findFirst()
        );
    }


    public static void findAny(List<Course> courses) {
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator
                .comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore);
        System.out.println(
                courses.stream()
                        .filter((Predicate<Course>) comparingByNoOfStudentsAndNoOfReviews)
                        .findAny()
        );
    }


}