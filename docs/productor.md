Claro, puedo ayudarte con eso. Parece que ya tienes una buena base para implementar un patrón de diseño de productor-consumidor, que es un patrón comúnmente utilizado para problemas de concurrencia como este.

En este patrón, tendrías un productor (en este caso, `FileReader`) que lee los archivos de forma concurrente y los coloca en una cola bloqueante. Luego tendrías un consumidor (en este caso, `TextProcessor`) que toma los archivos de la cola y los procesa de forma concurrente.

Aquí te dejo un ejemplo de cómo podrías implementarlo:

Primero, necesitarás una cola bloqueante para almacenar los archivos leídos. Esta cola se compartirá entre `FileReader` y `TextProcessor`.

```java
BlockingQueue<String> queue = new LinkedBlockingQueue<>();
```

Luego, en tu clase `FileReader`, puedes modificar el método `readFiles` para que coloque los archivos en la cola en lugar de devolver una lista:

```java
public class FileReader {
    // ...
    private final BlockingQueue<String> queue;

    public FileReader(String directory, BlockingQueue<String> queue) {
        this.directory = Objects.requireNonNull(directory, "Directory must not be a empty value");
        this.queue = queue;
    }

    public void readFiles() {
        // ...
        try(Stream<Path> paths = Files.list(path)) {
            paths
                .filter(Files::isRegularFile)
                .forEach(file -> {
                    try {
                        queue.put(Files.readString(file));
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, "Files doesn't contains anything" + file, e);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    // ...
}
```

En tu clase `ConcurrentProcessor`, puedes modificar el método `processFilesConcurrently` para que procese los archivos de la cola en lugar de una lista:

```java
public class ConcurrentProcessor {
    // ...
    private final BlockingQueue<String> queue;

    public ConcurrentProcessor(TextProcessor textProcessor, int numThreads, BlockingQueue<String> queue) {
        this.textProcessor = textProcessor;
        this.numThreads = numThreads;
        this.queue = queue;
    }

    public List<String> processFilesConcurrently() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        for (int i = 0; i < numThreads; i++) {
            executorService.submit(() -> {
                try {
                    while (true) {
                        String file = queue.take();
                        textProcessor.mostFrequentWords(file);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        return textProcessor.getCombinedResults();
    }
    // ...
}
```

Finalmente, puedes crear una instancia de `FileReader` y `ConcurrentProcessor` en tu método principal y hacer que trabajen juntos:

```java
public static void main(String[] args) {
    BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    TextProcessor textProcessor = new TextProcessor(new ArrayList<>());
    FileReader fileReader = new FileReader("./src/test/resources/", queue);
    ConcurrentProcessor concurrentProcessor = new ConcurrentProcessor(textProcessor, 4, queue);

    new Thread(fileReader::readFiles).start();
    concurrentProcessor.processFilesConcurrently();
}
```

Este es solo un ejemplo y puede que necesites ajustarlo para que se adapte a tus necesidades específicas.