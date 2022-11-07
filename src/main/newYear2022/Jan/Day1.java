package main.newYear2022.Jan;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Day1 {
    public static void main(String[] args) {
        int[] test1 = new int[] {1, 2, 3, 1};
        boolean result = findDuplicate(test1);
        System.out.println(result);
    }
    public static boolean findDuplicate(int[] test) {
        Arrays.sort(test);
        for (int i = 0; i < test.length -1 ; i++) {
            if (test[i] == test[i+1]) {
                return true;
            }
        }
        return false;
    }
}
