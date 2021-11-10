package main.Java11Exam.Collections.Arrays;

import java.util.Arrays;
import java.util.List;

public class Intro {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // for binary search, you need to use sorted array
        int index = Arrays.binarySearch(numbers, 5);
        System.out.println(index);

        int a = Arrays.binarySearch(numbers, 1, 6, 5);
        System.out.println(a);

        Student[] students = {
                new Student(11, "A"),
                new Student(12, "N"),
                new Student(13, "C"),
                new Student(9, "D")
        };
        int b = Arrays.binarySearch(students, new Student(12, "N"), (s1, s2) -> s1.id - s2.id);
        System.out.println(b);

        Arrays.sort(students, (s1, s2) -> s1.id - s2.id);

        Arrays.stream(students).forEach(s1-> System.out.print(s1.name));

        int[] copyOfNums = Arrays.copyOf(numbers, numbers.length);
        Arrays.stream(copyOfNums).forEach(System.out::print);
        System.out.println();
        numbers[1] = 100;
        Arrays.stream(numbers).forEach(System.out::println);
        // deep copy of the array, not just change the reference
        Arrays.stream(copyOfNums).forEach(System.out::print);
        System.out.println();
        int[] half = Arrays.copyOfRange(numbers, 0, 5);
        Arrays.stream(half).forEach(System.out::println);

        Integer[] numb = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // asList return the a fixed length list, so you can not add or remove
        List<Integer> list = Arrays.asList(numb);

        //System.out.print(list.remove(5));
        // System.out.println(list.add(new Integer(100)));
        int[] array = new int[10];
       Arrays.fill(array, 0);
       Arrays.stream(array).forEach(System.out::println);
    }
}
