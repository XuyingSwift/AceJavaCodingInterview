package main.Java11Exam.charpter14;

import javax.swing.*;
import java.util.*;

public class CollectionsCommenMethods {
    /*
     * List: A list is an ordered collection of elements that allows duplicate entries. Elements in a list can be accessed by an int index
     * Set: A set is a collection that does not allow duplicate entries
     * Queue: A queue is a collection that orders its elements in a specific order for processing . first in first out
     * Map: A map is a collction that maps keys to values, with no duplicate keys allowed. The elements in a map are key/value pairs
     * */

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        System.out.println(list.add("Sparrow"));
        System.out.println(list.add("Sparrow"));
        Collection<String> set = new HashSet<>();
        System.out.println(set.add("Key"));
        System.out.println(set.add("Key"));

        Collection<String> birds = new ArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        System.out.println(birds.remove("cardinal"));
        System.out.println(birds.remove("hawk"));

        birds.add("A");
        birds.add("B");
        birds.add("C");
        birds.add("D");

        // this will give you concurrentModificationException
        /*for (String b: birds) {
            birds.remove(b);
        }*/

        System.out.println(birds.isEmpty());
        System.out.println(birds.size());

        // the clear() method provides an easy way to discard all elements of the Collectionf

        birds.clear();
        System.out.println(birds.isEmpty());

        // the contains() method checks whether a certain value in a collection
        System.out.println(birds.contains("A"));


        Collection<String> list1 = new ArrayList<>();
        list1.add("Xuying");
        list1.add("Dawson");
        list1.add("Naomi");
        list1.add("Mia");

        System.out.println(list1);
        list1.removeIf(s -> s.startsWith("M"));
        System.out.println(list1);
        Arrays.asList(list1);
        System.out.println();
        list1.forEach(System.out::print);
        System.out.println();

        Collection<String> set1 = new HashSet<>();
        set1.add("wand");
        set1.add("");
        set1.removeIf(String::isEmpty);
        System.out.println(set1);
    }
}
