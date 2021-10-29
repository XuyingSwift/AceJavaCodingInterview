package main.algorithms.Sorting;

import java.util.Arrays;

public class BublleSort {
    public static void main(String[] args) {
        String[] x = {"de", "gh", "xy", "ab", "kl" };

        System.out.println("Before sort: " + Arrays.toString(x) );

        bubbleSort( x );  // Bubble sort

        System.out.println("\nAfter  sort: " + Arrays.toString(x) );
    }

    public static void bubbleSort(Comparable[] a) {
        Comparable help;
        boolean done = false;

        while (!done) {
            done = true;
            for (int i =0; i<a.length-1; i++){
                if (a[i].compareTo(a[i+1]) >0){
                    help = a[i];
                    a[i] = a[i+1];
                    a[i+1] = help;
                    done = false;
                }
            }
        }
    }
}
