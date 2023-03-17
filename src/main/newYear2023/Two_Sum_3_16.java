package main.newYear2023;

import java.util.Arrays;
import java.util.List;

public class Two_Sum_3_16 {
    public static void main(String[] args)
    {
        System.out.println("Happy New Year!");
        int[] nums = {1, 2, 3, 4};
        int target = 5;
        int[] results = new int[2];
        for (int i = 0; i < nums.length; i++)
        {
            int r = target - nums[i];
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[j] == r)
                {
                    results[0] = i;
                    results[1] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < results.length; i++)
        {
            System.out.println(results[i]);
        }
    }
}
