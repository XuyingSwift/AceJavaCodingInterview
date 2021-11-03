package main.Compnay.salesforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindTheKthFreqItem {

    public static void main(String[] args) {
        int[] a = {10, 1, 2, 2, 3, 4};
        int[] b = {2, 3};
        int target = 2;
        getTargetFreq(a, b, target);

    }

    public static void getTargetFreq(int[] a, int[] b, int target) {
        System.out.println(Arrays.toString(a));
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        for (int i =0; i<a.length; i++) {
            if (a[i] == target) {
                counter ++;
                map.put(counter, i);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i =0; i<b.length; i++) {
            if (map.containsKey(b[i])) {
                list.add(map.get(b[i]));
            }
        }

        System.out.println("the index is ");
        list.forEach(System.out::println);
    }
}
