package main.newYear2023.Apirl4;

import java.util.HashMap;

public class Valid_Anagram {
    public static void main(String[] args)
    {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagramWithChar(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> firstMap = new HashMap<>();
        HashMap<Character, Integer> secondMap = new HashMap<>();
        for (char i : s.toCharArray())
        {
            if(!firstMap.containsKey(i))
            {
                firstMap.put(i, 0);
            }else{
                firstMap.put(i, firstMap.get(i) + 1);
            }
        }

        for (char i : t.toCharArray())
        {
            if(!secondMap.containsKey(i))
            {
                secondMap.put(i, 0);
            }else{
                secondMap.put(i, secondMap.get(i) + 1);
            }
        }

        if (firstMap.size() != secondMap.size())
        {
            return false;
        }
        return firstMap.entrySet().stream()
                .allMatch(e -> e.getValue().equals(secondMap.get(e.getKey())));
    }

    public static boolean isAnagramWithChar(String s, String t)
    {
        // checkout basecase
        if (s.length() != t.length())
        {
            return false;
        }

        int[] store = new int[26];
        for (int i = 0; i < s.length(); i++){
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }
        for (int n : store) if (n != 0) return false;
        return true;
    }
}
