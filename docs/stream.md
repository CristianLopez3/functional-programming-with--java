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

| Método               | Descripción                                                                 |
|----------------------|-----------------------------------------------------------------------------|
| `filter(Predicate<T> predicate)` | Filtra los elementos del stream según un predicado dado.                       |
| `map(Function<T, R> mapper)`     | Transforma cada elemento del stream aplicando una función dada.                |
| `flatMap(Function<T, Stream<R>> mapper)` | Transforma cada elemento en un stream y los aplana en un único stream.     |
| `distinct()`         | Elimina elementos duplicados del stream.                                     |
| `sorted()`           | Ordena los elementos del stream de acuerdo a su orden natural.               |
| `sorted(Comparator<T> comparator)` | Ordena los elementos del stream utilizando un comparador dado.                  |
| `peek(Consumer<T> action)`       | Realiza una operación con cada elemento del stream sin modificar el stream.    |
| `limit(long maxSize)`            | Limita el número de elementos en el stream.                                      |
| `skip(long n)`                  | Omite los primeros `n` elementos del stream.                                    |
| `forEach(Consumer<T> action)`    | Realiza una acción para cada elemento del stream (operación terminal).          |
| `toArray()`                      | Devuelve un array que contiene los elementos del stream.                        |
| `reduce(BinaryOperator<T> accumulator)` | Reduce los elementos del stream a un solo valor usando un acumulador.          |
| `collect(Collector<T, A, R> collector)` | Acumula los elementos del stream en una colección, lista, mapa, etc.         |
| `anyMatch(Predicate<T> predicate)` | Devuelve `true` si algún elemento del stream coincide con el predicado dado.      |
| `allMatch(Predicate<T> predicate)` | Devuelve `true` si todos los elementos del stream coinciden con el predicado dado. |
| `noneMatch(Predicate<T> predicate)` | Devuelve `true` si ningún elemento del stream coincide con el predicado dado.     |
| `findFirst()`                   | Devuelve un `Optional` con el primer elemento del stream, si existe.             |
| `findAny()`                     | Devuelve un `Optional` con algún elemento del stream, si existe.                 |
| `count()`                       | Devuelve el número de elementos en el stream (operación terminal).               |
