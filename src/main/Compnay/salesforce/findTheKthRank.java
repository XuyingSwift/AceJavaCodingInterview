package main.Compnay.salesforce;

import java.util.Arrays;
import java.util.HashMap;

public class findTheKthRank {

    public static void arrayRank(int[] arr, int k) {
        System.out.println("Given array: " + Arrays.toString(arr));

        if (arr == null || arr.length ==0) {
            return;
        }

        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);

        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        int prev = temp[0];
        map.put(prev, rank);

        for (int i=1; i<arr.length; i++) {
            if (prev != temp[i]) {
                rank++;
            }
            map.put(temp[i], rank);
            prev=temp[i];
        }

        for (int i =0; i<arr.length; i++) {
            temp[i] = map.get(arr[i]);
        }

        System.out.println("Rank: " + Arrays.toString(temp));
        System.out.println("-------------------------------");
        System.out.println(k);

        for (int i =0; i<temp.length; i++) {
            if (temp[i] <=3) {
                System.out.println("items with in Kth rank: " + temp[i]);
            }
        }

    }

    public static void main(String[] args) {
        arrayRank(new int[] {22, 11, 44, 66, 55}, 3);
        arrayRank(new int[] {15, 12, 11, 10, 9}, 3);
        arrayRank(new int[] {10, 20, 30, 40, 50}, 3);
        arrayRank(new int[] {10, 10, 10, 10, 20}, 3);

    }

}
