package main.newYear2023.April16th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.*;

public class LearnArrayList {
    public static void main(String[] args)
    {
        ArrayList<Integer> lst = new ArrayList<>();

        // appends the specified element to the end of this list
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);

        // Inserts the specified element at the specified position in the list
        lst.add(1, 7);

        // Appends all of the elements in the specified collection to the end of this list,
        // in the order that they are returned by the specified collections's Iterator
        ArrayList<Integer> lst2 = new ArrayList<>(5);
        lst2.add(11);
        lst2.add(12);
        lst2.add(13);
        lst2.add(14);
        lst2.add(15);
        lst.addAll(lst2);
        System.out.println(lst);

    }
}
