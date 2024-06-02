# 🔗 Method References in Java

Method references in Java are a shorthand notation of a lambda expression to call a method. They were introduced in Java 8 and can make your code more readable and concise. Let's explore what method references are, how to use them, and see some practical examples.

## 🌟 What are Method References?

Method references are a way to refer to methods directly by their names. They provide a way to refer to existing methods without needing to write a lambda expression that calls that method.

### 📝 Syntax

The syntax for a method reference is:

ClassName::methodName

Or if you are using an instance:

instanceName::methodName


## 💡 Types of Method References

There are four kinds of method references:

1. **Reference to a static method**
2. **Reference to an instance method of a particular object**
3. **Reference to an instance method of an arbitrary object of a particular type**
4. **Reference to a constructor**

## 🔍 Examples

### 1. Reference to a Static Method

This is used to refer to a static method of a class.

```java
// Using lambda expression
Consumer<List<Integer>> sortListLambda = list -> Collections.sort(list);

// Using method reference
Consumer<List<Integer>> sortListMethodRef = Collections::sort;

List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
sortListMethodRef.accept(numbers);
System.out.println(numbers); // Outputs: [1, 1, 3, 4, 5, 9]
```

### 2. Reference to an Instance Method of a Particular Object
This refers to an instance method of a particular object.
```java
class Printer {
    public void print(String message) {
        System.out.println(message);
    }
}

// Using lambda expression
Printer printer = new Printer();
Consumer<String> printLambda = message -> printer.print(message);

// Using method reference
Consumer<String> printMethodRef = printer::print;

printMethodRef.accept("Hello, world!"); // Outputs: Hello, world!
```

### 3. Reference to an Instance Method of an Arbitrary Object of a Particular Type
This refers to an instance method of an arbitrary object of a specific type.

```java
// Using lambda expression
Function<String, Integer> stringLengthLambda = s -> s.length();

// Using method reference
Function<String, Integer> stringLengthMethodRef = String::length;

System.out.println(stringLengthMethodRef.apply("hello")); // Outputs: 5
```

### 4. Reference to a Constructor
This refers to a constructor.

```java
class Person {
    String name;
    Person(String name) {
        this.name = name;
    }
}

// Using lambda expression
Function<String, Person> personFactoryLambda = name -> new Person(name);

// Using method reference
Function<String, Person> personFactoryMethodRef = Person::new;

Person p = personFactoryMethodRef.apply("Alice");
System.out.println(p.name); // Outputs: Alice

```
## 🔥 Tips
* Use **method references for readability**: When a lambda expression just calls a method, consider using a method reference.
* **Ideal with functional interfaces**: They work seamlessly with Java's functional interfaces.
* **Code brevity**: Method references can make your code shorter and more expressive.