package main.Java11Exam.Collections.HashSet;

import java.util.*;

public class HashsetIntro {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.forEach(System.out::println);
        System.out.println(set.contains(3));

        set.remove(3);
        System.out.println(set);
        set.clear();
        System.out.println(set);
        System.out.println(set.isEmpty());

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for(Integer i : set) {
            System.out.println(i);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);

        int[] data = {12, 34, 1, 56, 43, 34, 5};
        HashSet<Integer> s = new HashSet<>();
        int duplicate = 0;
        for (int i=0; i< data.length; i++) {
            if (!s.add(data[i])) {
                duplicate = data[i];
                break;
            }
        }

        System.out.println("Duplicate " + duplicate);
    }
}
