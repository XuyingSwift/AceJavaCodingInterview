package main.newYear2023.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class Arpil24th_Longest_Repeating_Character_Replacement {
    public static void main(String[] args)
    {
        /**
         * Algorithm:
         * 1: loop through the array to make a map with each char and its freq, allLetters
         * 2: MaxSubLen is set to 0 and will be updated. Final result
         * 3: for each letter in allLetters, do:
         *      1: declare start, end and count (to record the number of As), set them to 0
         *      2: iterate through end from index 0 to last index:
         *          if end point to the char is the same as letter
         *              increase count by 1
         *          else if end points to a different char:
         *              check the current window is valid:
         *                  if so, move end to next
         *               if the current window is not valid:
         *                  move start to the next one, until the window is valid again
         *                  while moving start, if start points to the same letter, decrease the count
         *          compare MaxSubLen with the current window length, update MaxSubLen.
         * 4: return MaxSubLen;
         *
         */

        String s = "AABABBA";
        int k = 1;
        int result = longest_repeating_character_replacement(s, k);
        System.out.println(result);
    }

    public static int longest_repeating_character_replacement(String s, int k)
    {
        HashSet<Character> allLetters = new HashSet<>();
        // loop through the array to make a map with each char and its freq, allLetters
        for (int i = 0; i < s.length(); i++)
        {
            allLetters.add(s.charAt(i));
        }

        // MaxSubLen is set to 0 and will be updated. Final result
        int MaxSubLen = 0;

        for (Character letter : allLetters)
        {
            int start = 0;
            int count = 0;

            for(int end = 0; end < s.length(); end++)
            {
                // if end point to the char is the same as letter
                if (s.charAt(end) == letter)
                {
                    // if the letter matches, count increase
                    count ++;
                }

                while (!validWindow(start, end, count, k))
                {
                    // move start to the next one, until the window is valid again
                    // while moving start, if start points to the same letter, decrease the count
                    start = start + 1;
                    if (s.charAt(start) == letter)
                    {
                        count = count -1;
                    }
                }
                MaxSubLen = Math.max(MaxSubLen, end + 1 - start);
            }
        }
        return MaxSubLen;
    }

    public static boolean validWindow(int start, int end, int count, int k)
    {
        if ((end + 1 - start - count) <= k )
        {
            return true;
        }

        return false;
    }
}
