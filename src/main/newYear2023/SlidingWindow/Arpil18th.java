package main.newYear2023.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Arpil18th {
    public static void main(String[] args)
    {
        // return the maximum profit you can achieve from this transaction.
        int[] prices = {7,1,5,3,6,4};
        System.out.println("You buy on day 2 at price 1 and sell on day 5");
        System.out.println("The key here is to slide the window by one index");
        int result = buySellStock(prices);
        System.out.println(result);

        System.out.println("Given a string s, find the length of the longest substring without repeating chars");
        String str = "abcdeffff";
        int longest = longestSubstringWithoutRepeatingChars(str);
        System.out.println(longest);
        System.out.println(bruteForce(str));



    }
    public static int buySellStock(int[] prices)
    {
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;
        while(sell < prices.length)
        {
            if (prices[buy] < prices[sell])
            {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
                sell ++;
            } else {
                buy = sell;
                sell ++;
            }
        }
        return maxProfit;
    }

    public static int longestSubstringWithoutRepeatingChars(String str)
    {
        /*
         * Given a substring with a fixed end index in the string, maintain a hashmap to record the frequency of each
         * character in the current substring, If you any character occurs more than once, drop the left most characters
         * until there are no duplicate characters.
         * */
        System.out.println(
                "A sliding window is an abstract concept commonly used in array/string problems."
                        + "A window is a range of elements in the array/string  which usually defined by the start end end indices,"
                        + "A sldiing window is a window slides it two boundaries to the certain direction."
        );
        int left = 0;
        int right = 0;
        Map<Character, Integer> substr_frq = new HashMap<>();
        int result = 0;
        while (right < str.length())
        {
            char r = str.charAt(right);
            substr_frq.put(r, substr_frq.getOrDefault(r, 0) + 1);

            while(substr_frq.get(r) > 1)
            {
                char l = str.charAt(left);
                substr_frq.put(l, substr_frq.get(l) - 1);
                left ++;
            }
            result = Math.max(result, right - left + 1);
            right ++;
        }
        return result;
    }

    public static int bruteForce(String st)
    {
        int n = st.length();
        int res = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                if (checkRepetition(st, i, j))
                {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static boolean checkRepetition(String st, int start, int end)
    {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++)
        {
            char c = st.charAt(i);
            if (set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
