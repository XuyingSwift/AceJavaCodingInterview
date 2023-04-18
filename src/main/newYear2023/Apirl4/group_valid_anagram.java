package main.newYear2023.Apirl4;

import java.util.*;

public class group_valid_anagram {
    public static void main(String[] args){
        /*
        * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
         * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
         * typically using all the original letters exactly once.
         * Input: strs = ["eat","tea","tan","ate","nat","bat"]
         * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        * */


    }

    public static List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) return result;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs)
        {
            int[] hash = new int[26];
            for (char c : s.toCharArray())
            {
                hash[c - 'a']++;
            }
            String key = new String(Arrays.toString(hash));
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        result.addAll(map.values());
        return result;
    }
}
