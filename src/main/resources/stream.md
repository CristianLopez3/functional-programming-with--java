# Streams 


A **stream** in Java is a sequence of elements that can be processed declaratively. Streams allow you to perform operations like filtering, mapping, and reducing data in a concise and functional way. Streams do not store data; instead, they convey data from a source such as a collection, an array, or a file.

Streams in Java are created from collections and other data types using methods like `stream()` and `parallelStream()`. Operations on streams are divided into two types:
- **Intermediate**: Transform a stream into another stream, such as `filter()`, `map()`, and `sorted()`.
- **Terminal**: Produce a result or a side-effect, such as `forEach()`, `collect()`, and `reduce()`.

Technical example:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> evenNumbers = numbers.stream()
                                   .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toList());
System.out.println(evenNumbers); // Prints: [2, 4]
```

Imagine a stream in Java is like a conveyor belt in a cookie factory. The conveyor belt doesn't store the cookies 🍪, but carries them through various stations where different operations are performed, such as adding chocolate chips, baking, and packaging 📦.

1. **Intermediate Operations**: These are like the stations on the conveyor belt. Each station can do something with the cookies, like selecting only the ones with chocolate chips (filtering), transforming them into a different shape (mapping), or sorting them (sorting).

2. **Terminal Operations**: These are the end of the line where the cookies are collected in a box (collecting) or counted (reducing). At the end of the conveyor belt, you get a final result, like a box full of cookies ready to be shipped.

Analogy example:

* You have a conveyor belt (stream) 🛤️.
* You select only the cookies with chocolate chips (filter) 🍫.
* You pack the selected cookies in a box (collect) 📦.

## Important Methods

| Method             | Description                                                                           |
|--------------------|---------------------------------------------------------------------------------------|
| `filter`           | Filters the elements of the stream based on a given predicate.                        |
| `map`              | Transforms each element of the stream into another form using a given function.       |
| `flatMap`          | Transforms each element into a stream and then flattens these streams into one.       |
| `sorted`           | Sorts the elements of the stream based on a comparator or natural order.              |
| `distinct`         | Removes duplicate elements from the stream.                                           |
| `limit`            | Truncates the stream to contain no more than a given number of elements.              |
| `skip`             | Skips the first given number of elements in the stream.                               |
| `forEach`          | Performs an action for each element of the stream.                                     |
| `collect`          | Accumulates the elements of the stream into a collection or other mutable result.      |
| `reduce`           | Reduces the elements of the stream to a single value using an associative accumulation function. |
| `anyMatch`         | Returns `true` if any elements of the stream match the given predicate.               |
| `allMatch`         | Returns `true` if all elements of the stream match the given predicate.               |
| `noneMatch`        | Returns `true` if no elements of the stream match the given predicate.                |
| `findFirst`        | Returns the first element of the stream, if present.                                  |
| `findAny`          | Returns any element of the stream, if present.                                        |
| `count`            | Returns the count of elements in the stream.                                          |
_| `peek`             | Performs an action for each element of the stream and returns a stream of the same elements. |_

