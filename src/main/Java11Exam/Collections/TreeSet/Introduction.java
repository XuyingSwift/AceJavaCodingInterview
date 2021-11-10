package main.Java11Exam.Collections.TreeSet;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Introduction {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(14);
        set.add(10);
        set.add(11);
        set.add(9);
        set.add(22);

        System.out.println("the order without comparator" + set);
        TreeSet<Integer> reverse = new TreeSet<>(Collections.reverseOrder());
        reverse.add(14);
        reverse.add(10);
        reverse.add(11);
        reverse.add(9);
        reverse.add(22);
        reverse.add(50);
        reverse.add(1);
        reverse.add(100);

        System.out.println("reversed " + reverse);
        System.out.println("frist item int the treeset: "  + reverse.first());
        System.out.println("the last item in the tree set " + reverse.last());

        System.out.println("smaller than 22, " + reverse.headSet(22));
        System.out.println("larger than 22, " + reverse.tailSet(22));

        System.out.println("remove 22" + reverse.remove(new Integer(22)));

        System.out.println("contain 22 " + reverse.contains(22));

        System.out.println("The size of the tree set " + reverse.size());

        int[] numbers = {1,4,5,2,34,66,5,4,33,45,6,8,56,76,78,98,34,37,12,12,23,43,54,56};
        // can not do this as list
        TreeSet<Integer> nums = new TreeSet<Integer>();
        for (int i : numbers) {
            nums.add(i);
        }
        System.out.println(nums.tailSet(50));
        System.out.println(nums.first());
        System.out.println(nums.last());
    }
}
