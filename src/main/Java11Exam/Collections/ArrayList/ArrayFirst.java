package main.Java11Exam.Collections.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayFirst {

    public static void main(String[] args) {
        // Using the not-arg constructor, the list is size is zero
        List<Integer> list = new ArrayList();

        // using the constructor that takes initial capacity
        List list1 = new ArrayList(50);

        // Using existing collection
        List list2= new ArrayList(list1);

        list.add(1);
        list.add(2);
        list.add(3);

        list.add(4); // add at the end of the array
        System.out.println(list);

        list.add(1, 50);// add 50 at index 1
        list1.add(150);
        list1.add(160);
        // the the list1 to list
        list.addAll(list1);

        System.out.println(list);

        System.out.println("The item at index two is " + list.get(2));
        System.out.println("the size of the list is " + list.size());

        // remove the item at index 2
        list.remove(2);
        System.out.println("after removing the item at index 2" + list);

        list.remove(new Integer(150));
        System.out.println("this will remove 150 from the list" + list);

        list.clear();
        System.out.println("Clear out the list" + list);

        List<String> strings = new ArrayList<>();
        strings.add("String");
        strings.add("lover");

        strings.replaceAll((item) -> item.toUpperCase());
        System.out.println(strings);

        list.add(1);
        list.add(10);
        list.add(1);
        list.add(4);
        list.set(1, 200);
        System.out.println("updated arrayList" + list);

        if (list.contains(200)) {
            System.out.println(200);
        }
        System.out.println("Index of first occurence of 1 is " + list.indexOf(1));
        System.out.println("index of last occurence of 1 is " + list.lastIndexOf(1));

        // for loop
        for (int i =0; i<list.size(); i++) {
            System.out.println("loop througth a list " + list.get(i));
        }

        //enhanced loop
        for (int i : list) {
            System.out.println("Enhanced loop " + i);
        }

        // create Iterator
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println("Using iterator class " + iterator.next());
        }

        Iterator<Integer> newIterator = list.iterator();
        System.out.println("iterator throught using forEachremaining");
        newIterator.forEachRemaining(System.out::println);


        System.out.println("deleting directly from the list not the iterator");
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (next == 200) {
                list.remove(new Integer(200));
            }
        }
        System.out.println("Nothing happened");
        System.out.println(list);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        System.out.println(integerList);
        System.out.println("deleting directly from the iterator not the list");
        Iterator<Integer> iterator1 = integerList.iterator();

        while (iterator1.hasNext()) {

            int next = iterator1.next();

            if (next == 6) {
                iterator1.remove();
            }
            System.out.println(next);
        }

        System.out.println(integerList);
        System.out.println(list);


        while (iterator1.hasNext()) {
            // can not add new item to the list after iterator is created
            //System.out.println(iterator1.next());
        }
    }
}
