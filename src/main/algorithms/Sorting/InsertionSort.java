package main.algorithms.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int [] arr = {5,2,12,12,1};
        insertionSort(arr);

        for (int i = 0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i =0; i<arr.length; i++) {
            int j = i;
            while (j>0 && arr[j-1] > arr[j]){
                // the iteration start at index 1
                // check all values on the left side of the key
                // is the left side is greater then current key index
                // swap
                // move key index, and then check
                int key = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = key;
                j = j -1;
            }
        }
    }
}
