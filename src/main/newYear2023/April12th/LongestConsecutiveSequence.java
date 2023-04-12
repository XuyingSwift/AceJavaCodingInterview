package main.newYear2023.April12th;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args)
    {
        /*
        * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
        * you must write an algorithm that runs in O(n) time.
        * */

        int[] nums = {100, 4, 200, 3, 2, 1};
        System.out.println(Arrays.toString(nums));
        int result = getLongest(nums);
        System.out.println(result);
    }

    public static int getLongest(int[] nums)
    {
        if (nums.length == 0){
            return 0;
        }
        HashSet<Integer> nums_set = new HashSet<>();
        for (int i : nums)
        {
            nums_set.add(i);
        }

        int longest = 0;
        for (int i : nums)
        {
            if (!nums_set.contains(i -1))
            {
                int position = 1;
                while(nums_set.contains(i+position))
                {
                    position++;
                }
                longest = Math.max(longest, position);
            }

        }
        return longest;
    }
}
