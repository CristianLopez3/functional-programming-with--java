#  🌟 Functional Programming With Java 

Hey, welcome to my repository to learning functional programming with java with the course of "@in28Minutes" in udemy...

>[!NOTE]
> Go ahead and check the code, probably you will find something interesting or probably no...


### 🖋 ️Use this repo

**clone the repo** with the next commands:

```shell
git clone https://github.com/CristianLopez3/functional-programming-with--java.git functional-programming
cd functional-programming
```


### 📚 Content

Let's dive into some concepts:

* [`Lambdas`](./docs/lambdas.md)
* [`Stream`](./docs/stream.md)
* [`Method Reference`](./docs/method_reference.md)
* [`Functional Interfaces`](./docs/functional_interfaces.md)

### What is Functional Programming?

Functional programming is a programming paradigm that emphasizes constructing software by using pure functions, avoiding shared state and mutable data. In functional programming, functions are treated as first-class citizens, meaning they can be passed as arguments, returned from other functions, and assigned to variables. This approach promotes immutability, where data structures are not modified after they are created, and focuses on declarative code where the logic of computation is expressed without explicitly describing its control flow. Functional programming helps in writing more predictable, modular, and testable code by leveraging principles like higher-order functions, transparency referential, and lazy evaluation.



## Concurrent Text File Processing System
### Overview:

This project aims to develop a concurrent text file processing system. The system will read multiple text files, process their content functionally, and then combine the results concurrently. This project will allow you to practice functional programming (using streams and lambdas) and concurrency (using CompletableFuture, ExecutorService, etc.).

### Key Features:

* **Text File Reading**: Reads multiple text files from a specified directory.
Functional Processing: Performs various operations on the file content using functional programming (e.g., counting words, finding most frequent words, etc.).
* **Concurrency**: Processes text files concurrently to improve efficiency.
* **Result Aggregation**: Combines the results of concurrent processing and presents a final result (e.g., a list of the most frequent words in all files).


### Technologies and Concepts:

* **Java Streams and Lambdas**: For performing functional operations on file content.
* **CompletableFuture**: For handling asynchronous tasks and concurrency.
* **ExecutorService**: For managing execution threads.
* **File I/O (NIO)**: For reading text files efficiently.


