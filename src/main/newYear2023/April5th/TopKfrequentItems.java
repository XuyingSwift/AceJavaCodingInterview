package main.newYear2023.April5th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopKfrequentItems {
    public static void main(String[] args){
        int[] nums = {1,1,1,3,3,4,5,6,6,6,6};
        int[] res = topKFreqItems(nums, 3);
        System.out.println(Arrays.toString(res));
    }

    public static int[] topKFreqItems(int[] nums, int k)
    {
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer> bucket[] = new ArrayList[nums.length + 1];

        /*
        * The merge() method takes 3 parameters:
            key - key with which the specified value is to be associated
            value - value to be associated with key, if key is already associated with any value
            remappingFunction - result to be associated with key if key is already associated with a value
        * */
        for (int num : nums)
        {
            count.merge(num, 1, Integer::sum);
        }

        for (int key : count.keySet())
        {
            int freq = count.get(key);
            if (bucket[freq] == null)
            {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int index = 0;
        int[] res = new int[k];
        for (int i = nums.length; i >= 0; i--)
        {
            if (bucket[i] != null)
            {
                for (int val : bucket[i])
                {
                    res[index++] = val;
                    if (k == index)
                    {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
