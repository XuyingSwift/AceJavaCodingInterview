package main.DataStructure.Arrays;

import java.util.Arrays;
import java.util.Collections;

public class TwoItemsSumToN {
    public static void main(String[] args) {
        // test array
        int[] test1 = {1,2,3,4,5};
        rotateByOne(test1);
        Arrays.stream(test1).forEach(System.out::print);
        System.out.println();
        int[] test2 ={6,7,8,9,10};
        rotateByK(test2, 2);
        System.out.println();
        Arrays.stream(test2).forEach(System.out::print);
        System.out.println();
        System.out.println("print out two sums");
        int[] test3 = {21, 12, 3, 5, 100};
        int[] r = getTwoSum(test3, 26);
        Arrays.stream(r).forEach(System.out::println);

        Arrays.stream(twoSum(test3, 26)).forEach(System.out::print);

        System.out.println();
        int k = searchMinDifferentDistance(test3, 24);
        System.out.println(k);

        System.out.println(search(test3, 24));

    }

    public static void rotateByOne(int[] arr) {
        //Store Last Element of Array.
        //Start from last and Right Shift the Array by one.
        //Store the last element saved to be the first element of array.
        int lastElement = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = lastElement;
    }

    public static void rotateByK(int[] arr, int k) {
        int temp, prev;
        for (int i =0; i < k; i++) {
            System.out.println("i " + i);
            prev = arr[arr.length -1];
            System.out.println("prev " + prev);
            for (int j =0; j<arr.length; j++) {
                System.out.print("j " + j);
                temp = arr[j];
                arr[j] = prev;
                prev = temp;
                System.out.print("prev " + prev);
            }
        }
    }

    public static int[] getTwoSum(int[] arr, int n) {
        Arrays.sort(arr);

        int Pointer1 = 0;    //Pointer 1 -> At Start
        int Pointer2 = arr.length - 1;   //Pointer 2 -> At End

        int[] result = new int[2];
        int sum = 0;

        while (Pointer1 != Pointer2) {

            sum = arr[Pointer1] + arr[Pointer2];  //Calulate Sum of Pointer 1 and 2

            if (sum < n)
                Pointer1++;  //if sum is less than given value => Move Pointer 1 to Right
            else if (sum > n)
                Pointer2--;
            else {
                result[0] = arr[Pointer1];
                result[1] = arr[Pointer2];
                return result; // containing 2 number
            }
        }
        return arr;
    }

    public static int[] twoSum(int[] arr, int n) {
        int[] result = new int[2];
        for (int i =0; i <arr.length; i++) {
            for (int j =1; j< arr.length; j++) {
                if (arr[i] + arr[j] == n) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                    return result;
                }
            }
        }
        return arr;
    }

    public static int searchMinDifferentDistance(int[] arr, int k) {
        int min = 0;

        for (int i =0; i<arr.length; i++) {
            if (k - arr[i] > min) {
                min = k -arr[i];
            }
        }

        return min;
    }

    public static int search(int[] arr, int key) {
        Arrays.sort(arr);
        if (key < arr[0]) {
            return arr[0];
        }

        if (key > arr[arr.length -1]) {
            return arr[arr.length -1];
        }

        int start =0;
        int end = arr.length -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }

        // at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array
        // return the element which is closest to the 'key'
        if ((arr[start] - key) < (key - arr[end]))
            return arr[start];
        return arr[end];

    }


}
