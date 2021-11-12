package main.DataStructure.Arrays;

import java.util.Arrays;

public class PutArrayToMinMaxPair {
    public static void main(String[] args) {
        System.out.println("put max, min pair in an array");
        int[] arr = {20, 10, 33, 15, 45, 60};
        Arrays.stream(pair(arr)).forEach(s -> System.out.print(s + " "));
        int[] test = {-1, 0, -4, 5};
        System.out.println();
        rearrangeByNegativeAndPositive(test);

        int[] v1 = new int[]{6, 7, 10, 25, 30, 63, 64};
        int[] v2 = new int[]{0, 4, 5, 6, 7, 8, 50};
        int[] v3 = new int[]{1, 6, 10, 14};
        System.out.println();
        System.out.println(findMaxSubSum(arr));
        System.out.println(findMaxSubSum(test));
        System.out.println();
        System.out.println(findTheSmallestCommonItem(v1, v2, v3));

        Interval[] intervals = {new Interval(2, 4), new Interval(1, 3), new Interval(3, 5)};
        boolean flag = validateIntervals(intervals);
        System.out.println(flag);

    }

    public static int[] pair(int[] arr) {
        Arrays.sort(arr);
        int[] newArray = new int[arr.length];

        int min = 0;
        int max = arr.length -1;

        boolean flag = true;
        for (int i =0; i< arr.length; i++) {
            if (flag) {
                newArray[i] = arr[max--];
            }else{
                newArray[i] = arr[min++];
            }
            flag = !flag;
        }
        return newArray;
    }

   public static void rearrangeByNegativeAndPositive(int[] array) {
        int[] newArray = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                newArray[index++] = array[i];
            }
        }

        for (int i =0; i< array.length; i++) {
            if (array[i] > 0) {
                newArray[index++] = array[i];
            }
        }

       Arrays.stream(newArray).forEach(s -> System.out.println(s + " "));
   }

   public static int findMaxSubSum(int[] array) {
        int currentMax = array[0];
        int globalMax = array[0];
        for (int i =0; i<array.length; i++) {
            if (currentMax < 0) {
                currentMax = array[i];
            }else {
                currentMax = currentMax + array[i];
            }

            if (globalMax < currentMax) {
                globalMax = currentMax;
            }
        }
        return globalMax;

   }

   public static int findTheSmallestCommonItem(int[] arr1, int[] arr2, int[] arr3) {
       int i = 0, j = 0, k = 0;

       while(i < arr1.length && j < arr2.length && k < arr3.length) {

           // Finding the smallest common number
           if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
               return arr1[i];
           }

           // Let's increment the iterator
           // for the smallest value.

           if(arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
               i++;
           }

           else if(arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
               j++;
           }

           else if(arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
               k++;
           }
       }
       return -1;
   }

   public static boolean validateIntervals(Interval[] intervals) {
       // sort the intervals by start time
       Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

       // find any overlapping appointment
       for (int i = 1; i < intervals.length; i++) {
           if (intervals[i].start < intervals[i - 1].end) {
               // please note the comparison above, it is "<" and not "<="
               // while merging we needed "<=" comparison, as we will be merging the two
               // intervals having condition "intervals[i].start == intervals[i - 1].end" but
               // such intervals don't represent conflicting appointments as one starts right
               // after the other
               return false;
           }
       }
       return true;
   }
}
