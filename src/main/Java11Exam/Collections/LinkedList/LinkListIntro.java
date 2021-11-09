package main.Java11Exam.Collections.LinkedList;


import java.util.LinkedList;

public class LinkListIntro {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        System.out.println(list);

        list.addFirst(10);
        System.out.println(list);

        list.add(2, 30);
        System.out.println(list);

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(101);
        list1.add(102);
        list1.add(103);

        list.addAll(list1);
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(1));

        System.out.println(list.remove());
        System.out.println(list.remove(2));
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());

        System.out.println("Occurenc");
        System.out.println(list.removeFirstOccurrence(3));
        System.out.println(list.removeLastOccurrence(3));

    }
}
