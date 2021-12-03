package main.DataStructure.Arrays;

import java.util.Arrays;

public class Leetcode27RemoveElement {
    public static void main(String[] args) {
       int[] arr = {1, 1, 2, 3,4};
       int r = remvoeElement(1, arr);
        System.out.println(r);
        System.out.println("jhajajajaja");
        Arrays.stream(remvoe(1, arr)).forEach(System.out::println);
    }

    public static int remvoeElement(int elem, int[] A) {
        // to shift the array, we need to have a var to keep track the index number
        int begin =0;

        for (int i =0; i < A.length; i++) {
            if (A[i] != elem) {
                A[begin] = A[i];
                begin++;
            }
        }
        return begin;
    }

    public static int[] remvoe(int elem, int[] A) {
        // to shift the array, we need to have a var to keep track the index number
        int begin =0;

        for (int i =0; i < A.length; i++) {
            if (A[i] == elem) {
                A[begin] = A[i+1];
                begin++;
            }
        }
        return A;
    }
}
