package main.newYear2022.Jan;

import java.util.Arrays;
import java.util.HashMap;

public class Jan5th {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = bruteForce(nums, target);
        Arrays.stream(result).forEach(System.out::println);

        result = hashmap(nums, target);
        Arrays.stream(result).forEach(System.out::println);
    }

    // brute force approach, nested loop to the target - nums[i] O(n^2)
    public static int[] bruteForce(int[] nums, int target) {
        for (int i =0; i<nums.length; i++) {
            for (int j = i +1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // hashtable O(n)
    public static int[] hashmap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0; i<nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
