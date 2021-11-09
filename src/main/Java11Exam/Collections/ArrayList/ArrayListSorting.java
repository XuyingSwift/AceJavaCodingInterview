package main.Java11Exam.Collections.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListSorting {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);

        Collections.sort(list);
        System.out.println(list);

        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("using stream().sorted().collection()" + sortedList);

        System.out.println("print the list with reversed order");
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("reversed order " + list);

        List<Integer> sorted = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sorted list using stream()" + sorted);
    }
}
