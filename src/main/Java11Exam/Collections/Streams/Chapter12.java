package main.Java11Exam.Collections.Streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter12 {
    public static void main(String[] args) throws IOException {
        System.out.println("You have already seen that you can turn any collection into a stream with the stream method of the collection interface.");
        var contents = new String(Files.readAllBytes(Paths.get("/Users/xswift/Desktop/AceJavaCodingInterview/src/main/Java11Exam/Collections/Streams/news.txt")), StandardCharsets.UTF_8);
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        List<String> food = new ArrayList<>();
        food.add("apples");
        food.add("honey");
        food.add("rice");
        Stream.of(food).forEach(System.out::println);

        System.out.println("Create an empty stream");
        Stream<String> silence = Stream.empty();
        // Stream<String> echos = Stream.generate(() -> "Echo");
        // echos.forEach(System.out::println);
        // Stream<Double> randoms = Stream.generate(Math::random);
        // randoms.forEach(System.out::println);

        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("word", words);
        show("songs", song);
        show("silence", silence);

    }

    public static <T> void show(String title, Stream<T> stream)
    {
        final int SIZE = 10;
        List<T> firstEle = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.println(title + " : ");
        for (int i = 0; i < firstEle.size(); i++)
        {
            if (i > 0) System.out.print(", ");
            if (i < SIZE) System.out.print(firstEle.get(i));
            else System.out.print("...");
        }
        System.out.println();
    }
}
