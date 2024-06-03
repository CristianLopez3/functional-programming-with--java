package com.finance;


import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Project {

    private static final String DIRECTORY = "./src/main/resources/";
    private static final int LIMIT_OF_WORDS = 15;

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        List<String> filesContent = readFiles(DIRECTORY);
        System.out.println("""
                ================================================
                LIST OF WORDS
                ================================================
                """);
        System.out.println(listOfWords(filesContent));

        System.out.println("""
                ================================================
                MOST USED WORDS
                ================================================
                """);
        System.out.println(
                mostUsedWords(filesContent, LIMIT_OF_WORDS).entrySet()
                        .stream()
                        .map(e -> e.getKey() + " - " + e.getValue()).collect(Collectors.joining(". \n"))
        );

        System.out.println("""
                ================================================
                FIND AN SPECIFIC WORD
                ================================================
                """);
        System.out.println(findHowManyTimesIsWord(filesContent, "java"));

    }

    public static List<String> readFiles(String directory) throws IOException {
        try (Stream<Path> files = Files.walk(Paths.get(directory))) {
            return files.parallel()
                    .filter(Files::isRegularFile)
                    .map(Project::readFileContent)
                    .toList();
        }
    }

    private static String readFileContent(Path file) {
        try {
            return Files.readString(file);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static Map<String, Long> listOfWords(List<String> content) {
        return processWords(content)
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));
    }

    public static Map<String, Long> mostUsedWords(List<String> content, int limitOfWords) {
        return processWords(content)
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limitOfWords)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static Map<String, Long> findHowManyTimesIsWord(List<String> words, String word) {
        return processWords(words)
                .filter(w -> w.equals(word))
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));
    }

    private static Stream<String> processWords(List<String> content) {
        return content.parallelStream()
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .map(word -> word.replaceAll("\\W", ""))
                .filter(word -> !word.isBlank())
                .map(String::toLowerCase);
    }


}