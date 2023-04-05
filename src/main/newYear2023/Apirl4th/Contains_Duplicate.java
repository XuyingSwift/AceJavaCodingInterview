package main.newYear2023.Apirl4th;

import java.util.HashSet;

public class Contains_Duplicate {
    /*
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    */
    public static void main(String[] args)
    {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums)
        {
            if (set.contains(i))
            {
                return true;
            }else{
                set.add(i);
            }
        }
        return false;
    }
}
