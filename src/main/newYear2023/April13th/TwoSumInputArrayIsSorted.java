package main.newYear2023.April13th;

public class TwoSumInputArrayIsSorted {
    public static void main(String[] args)
    {
        int[] numbers = {2, 3, 7, 9};
        int target = 9;
        int[] results = twoSum(numbers, target);
        for (int i : results)
        {
            System.out.print(i + " ");
        }

    }

    public static int[] twoSum(int[] nums, int target)
    {
        int l_pointer = 0;
        int r_pointer = nums.length - 1;
        while(l_pointer < r_pointer)
        {
            int sum = nums[l_pointer] + nums[r_pointer];
            if (sum == target)
            {
                return new int[]{l_pointer, r_pointer};
            } else if (sum < target)
            {
                l_pointer ++;
            }else {
                r_pointer --;
            }
        }
        return new int[]{-1, -1};
    }
}
