package main.Java11Exam;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        var a = new LinkedList<String>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        var b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");

        ListIterator<String> aiterator = a.listIterator();
        Iterator<String> biterator = b.iterator();

        while (biterator.hasNext()) {
            if (aiterator.hasNext()) aiterator.next();
            aiterator.add(biterator.next());
        }
        System.out.println(a);
    }
}
