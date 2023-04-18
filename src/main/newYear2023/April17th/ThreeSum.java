package main.newYear2023.April17th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args)
    {
        System.out.println(
                "Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] "
                        + "such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.\n" +
                        "\n" +
                        "Notice that the solution set must not contain duplicate triplets.");
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> ll : res) {
            for (Integer i : ll)
            {
                System.out.println(i);
            }
        }

        /*
        * For Main Function:
        *  sort the int array
        *  Loop through the array:
        *   if the current index is more than 0, the result will not add to 0
        *   else:
        *     if i ==0 or pre != current
        *       call twoSum
        * TwoSum
        *   set left pointer is i + 1
        *   set right pointer is nums.length - 1
        *   loop:
        *     if sum = 0
        *       put the items into an array
        *       while lo < right and pre != next
        *        move lo to next to see if there is more items add to 0
        *
        * */
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        return res;
    }
    public static void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }

}
