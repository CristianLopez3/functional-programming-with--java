# 🚀 Lambdas in Java

Java Lambdas are one of the most exciting features introduced in Java 8. They allow you to write concise, functional-style code by treating functions as first-class citizens. Let's dive into what Lambdas are, how to use them, and some practical examples.

## 🌟 What are Lambdas?

A lambda expression is a short block of code which takes in parameters and returns a value. Lambdas are similar to methods, but they do not need a name and can be implemented right in the body of a method.

### 📝 Syntax

The syntax for a lambda expression is:

(parameters) -> expression



## 💡 Key Concepts

- **No need for boilerplate code**: No need for anonymous classes.
- **Functional Interfaces**: Lambdas can be used wherever a functional interface is expected.
- **Readability**: Makes code more readable and concise.

## 🔍 Examples

### 1. Simple Lambda

Let's start with a simple example:

```java
// Traditional way using an anonymous class
Runnable r1 = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello, world!");
    }
};

// Using lambda expression
Runnable r2 = () -> System.out.println("Hello, world!");

r1.run();
r2.run();
```

###  Lambda with Parameters

Lambdas can take parameters, just like methods:

```java
// Using a traditional anonymous class
Comparator<Integer> comparator1 = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
};

// Using lambda expression
Comparator<Integer> comparator2 = (Integer o1, Integer o2) -> o1.compareTo(o2);

// Even more concise
Comparator<Integer> comparator3 = (o1, o2) -> o1.compareTo(o2);

System.out.println(comparator1.compare(3, 2)); // 1
System.out.println(comparator2.compare(3, 2)); // 1
System.out.println(comparator3.compare(3, 2)); // 1
```


### Lambda with Multiple Statements

If your lambda body needs multiple statements, use curly braces {}:

```java
// Example with multiple statements
Consumer<String> consumer = (String s) -> {
    s = s.toUpperCase();
    System.out.println(s);
};

consumer.accept("hello"); // Outputs: HELLO
```

###  Lambdas in Collections

Lambdas are super useful with collections, especially with the Stream API:

```java

List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Using lambda to print all names
names.forEach(name -> System.out.println(name));

// Using lambda to filter names
List<String> filteredNames = names.stream()
    .filter(name -> name.startsWith("A"))
    .collect(Collectors.toList());

System.out.println(filteredNames); // Outputs: [Alice]

```

## 🛠 Functional Interfaces

A functional interface is an interface with just one abstract method. Examples include Runnable, Comparator, and custom ones you define.

```java
@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod();
}

// Using the custom functional interface with lambda
MyFunctionalInterface instance = () -> System.out.println("My method implementation");
instance.myMethod();

```

## 🔥 Tips
* Use lambdas to make your code cleaner and more readable.

* They are perfect for short blocks of code that are used only once.

* Make sure to use them in conjunction with the Stream API to leverage functional programming in Java.