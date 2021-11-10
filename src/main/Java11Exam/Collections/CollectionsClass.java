package main.Java11Exam.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsClass {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(13);
        list.add(10);
        list.add(193);
        list.add(1434);
        list.add(23);
        list.add(12);

        List<Integer> l = new ArrayList<>();
        l.add(19);
        l.add(1923);
        l.add(193);
        l.add(19342);
        l.add(191);

        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
        System.out.println(Collections.frequency(list, 13));
        System.out.println(Collections.binarySearch(list, new Integer(193)));

        Collections.copy(list, l);
        System.out.println(list);
        Collections.fill(list, 0);
        System.out.println(list);

    }
}
