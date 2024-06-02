
# What is a Functional Interface? 🤔

A **functional interface** is a special type of interface in Java that has **only one abstract method**. Think of it as a blueprint for a function! 📝

>[!NOTE]
> Interfaces in java can contain static and predetermine methods.

### What's it for? 📌

Functional interfaces are made for using **lambda expressions** and **method references**, which are fancy ways to write short and sweet code. They help you avoid writing tons of boilerplate code.

### When can I use it? 🛠️

You can use functional interfaces whenever you need to pass around a piece of code as if it were an object. This is super handy for things like:

- **Filtering** a list of items 🍎🍌
- **Transforming** data 📊
- **Performing actions** on each item in a collection 🔄

### Example Code 🎉

Here's a simple example of using a functional interface:

```java
import java.util.function.Predicate;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // A Predicate is a functional interface that takes one argument and returns a boolean
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // Use the predicate to check if a number is even
        boolean result = isEven.test(4); // Returns true

        System.out.println("Is 4 even? " + result);
    }
}
```

### Why Use It? 🚀
Using functional interfaces with lambdas:

* Makes your code shorter and cleaner ✨
* Helps you write less boilerplate 📝
* Allows you to pass behavior around as if it were data 📦


## Most Used Functional Interfaces

| Functional Interface | Description                                                                                     |
|----------------------|-------------------------------------------------------------------------------------------------|
| `Function<T, R>`     | Represents a function that takes one argument and produces a result.                            |
| `BiFunction<T, U, R>`| Represents a function that takes two arguments and produces a result.                           |
| `Consumer<T>`        | Represents an operation that takes a single argument and returns no result.                    |
| `BiConsumer<T, U>`   | Represents an operation that takes two arguments and returns no result.                        |
| `Supplier<T>`        | Represents a supplier of results; provides a result without taking any arguments.              |
| `Predicate<T>`       | Represents a predicate (boolean-valued function) of one argument.                              |
| `BiPredicate<T, U>`  | Represents a predicate (boolean-valued function) of two arguments.                             |
| `UnaryOperator<T>`   | Represents an operation on a single operand that produces a result of the same type as its operand. |
| `BinaryOperator<T>`  | Represents an operation upon two operands of the same type, producing a result of the same type.|
| `Callable<V>`        | Represents a task that returns a result and may throw an exception.                            |
| `Runnable`           | Represents a task that does not return a result and cannot throw a checked exception.      |

        
* **Function<T, R>**: A function that takes one input and returns a result.

```java
Function<String, Integer> lengthFunction = String::length;
Integer length = lengthFunction.apply("Hello"); // Returns 5
BiFunction<T, U, R>: A function that takes two inputs and returns a result.
```

* **BiFunction<T, U, R>**: A function that takes two inputs and returns a result.
```java
BiFunction<Integer, Integer, Integer> sumFunction = (a, b) -> a + b;
Integer sum = sumFunction.apply(2, 3); // Returns 5
Consumer<T>: An operation that takes one input and returns no result.
```

* **Consumer<T>**: An operation that takes one input and returns no result.
```java
Consumer<String> printConsumer = System.out::println;
printConsumer.accept("Hello"); // Prints "Hello"
BiConsumer<T, U>: An operation that takes two inputs and returns no result.
```

* **BiConsumer<T, U>**: An operation that takes two inputs and returns no result.
```java
BiConsumer<String, Integer> printBiConsumer = (s, i) -> System.out.println(s + " " + i);
printBiConsumer.accept("Number:", 10); // Prints "Number: 10"
Supplier<T>: A supplier of results.
```

* **Supplier<T>**: A supplier of results.
```java
Supplier<Double> randomSupplier = Math::random;
Double randomValue = randomSupplier.get(); // Returns a random value
Predicate<T>: A function that takes one input and returns a boolean.
```

* **Predicate<T>**: A function that takes one input and returns a boolean
```java
Predicate<Integer> isEvenPredicate = n -> n % 2 == 0;
boolean isEven = isEvenPredicate.test(4); // Returns true
BiPredicate<T, U>: A function that takes two inputs and returns a boolean.
```

* **BiPredicate<T, U>**: A function that takes two inputs and returns a boolean.
```java
BiPredicate<String, String> startsWithPredicate = (str, prefix) -> str.startsWith(prefix);
boolean startsWith = startsWithPredicate.test("Hello", "He"); // Returns true
UnaryOperator<T>: An operation on a single operand that returns a result of the same type.
```

* **UnaryOperator<T>**: An operation on a single operand that returns a result of the same type.
```java

UnaryOperator<Integer> squareOperator = x -> x * x;
Integer square = squareOperator.apply(5); // Returns 25
BinaryOperator<T>: An operation on two operands of the same type that returns a result of the same type.
```

* **BinaryOperator<T>**: An operation on two operands of the same type that returns a result of the same type.
```java
BinaryOperator<Integer> multiplyOperator = (a, b) -> a * b;
Integer product = multiplyOperator.apply(3, 4); // Returns 12
```


* **Callable**: a task that returns a result and may throw an exception.
```java
Callable<Integer> callableTask = () -> {
    Thread.sleep(1000);
    return 123;
};
```

* **Runnable**: A task that does not return a result and cannot throw a checked exception.

```java
Runnable runnableTask = () -> System.out.println("Task is running");
runnableTask.run(); // Prints "Task is running"

```