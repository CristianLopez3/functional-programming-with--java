package com.finance.programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP07FlatMap {

    public static void main(String[] args) {

        List<String> courses = List.of(
                "Docker", "AWS", "Spring boot", "API",  "Spring", "Kubernetes", "Microservices");

        List<String> courses2 = List.of(
                "Docker", "AWS", "Spring boot", "API",  "Spring", "Kubernetes", "Microservices");

        System.out.println(courses.stream()
                .collect(Collectors.joining(" ")));

        System.out.println(courses.stream()
                .map(course -> course.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList()));

        System.out.println(
            courses.stream()
                    .flatMap(course -> courses2.stream()
                            .filter(course2 -> course2.length() == course.length())
                            .map(course2 -> List.of(course, course2)))
                    .filter(list -> !list.get(0).equals(list.get(1)))
                    .toList()
        );


    }


;;}
