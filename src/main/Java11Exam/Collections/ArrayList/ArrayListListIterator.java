package main.Java11Exam.Collections.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListListIterator {

    public static void main(String[] args) {
        System.out.println("ArrayList's List Iterator");

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("the orignal list " + list);

       ListIterator<Integer> listIterator = list.listIterator();

        System.out.println("Forward iteration");
        while (listIterator.hasNext()) {
            System.out.println("forward moving " + listIterator.next());
        }

        System.out.println("Backward iteration ");
        while (listIterator.hasPrevious()) {
            System.out.println("Previous element is " + listIterator.previous() +
                    " and previous index is " + listIterator.previousIndex());
            listIterator.add(new Integer(60));
            break;

        }



        System.out.println("altered list " + list);
    }
}
