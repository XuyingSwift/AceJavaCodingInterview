package main.Java11Exam.Collections.Streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Chapter11 {
    public static void main(String[] args) throws IOException {
        System.out.println("Streams provide a view of data that lets you specify computations at a higher conceptual level.");
        System.out.println("With a stream, you specify what you want to have done, not how to do it");
        System.out.println("You leave the scheduling of operations into implementation.");

        System.out.println("The Difference between Collection and Stream");
        System.out.println("1: A stream does not store its elements.");
        System.out.println("2: Stream operations don't mutate their source.");
        System.out.println("3: Stream operations are lay when possible.");

        System.out.println("The workflow of streams");
        System.out.println("1: create a stream");
        System.out.println("2: Specify intermediate operations for transforming the initial stream into others, possibly in multiple steps");
        System.out.println("3: Apply a terminal operation to produce a result. This operation forces the execution of the lazy operation that precede it. afterwards, the stream can not longer be used");

        var contents = new String(Files.readAllBytes(Paths.get("/Users/xswift/Desktop/AceJavaCodingInterview/src/main/Java11Exam/Collections/Streams/news.txt")), StandardCharsets.UTF_8);
        List<String> words = List.of(contents.split("\\PL+"));
        countLongWords(words);

    }

    public static void countLongWords(List<String> words)
    {
        int count = (int) words.stream().filter(w -> w.length() > 5).count();
        System.out.println(count);
    }
}
