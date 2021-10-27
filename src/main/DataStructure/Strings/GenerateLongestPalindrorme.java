package main.DataStructure.Strings;

import java.util.HashSet;
import java.util.Set;

public class GenerateLongestPalindrorme {

    public static void main(String[] args) {
        String s = "abcdeeff";
        String[] s1 = {"ab", "ba", "cd"};
        String s2 = String.join("", s1);
        findLongestPalindrome(s);
        findLongestPalindrome(s2);
    }

    public static void findLongestPalindrome(String str) {
        Set<Character> characterSet = new HashSet<>();
        for (Character c : str.toCharArray()) {
            if (characterSet.contains(c)) {
                characterSet.remove(c);
            }else{
                characterSet.add(c);
            }
        }
        characterSet.forEach(System.out::println);
        int longestPalindrome = str.length() - characterSet.size() + 1;
        System.out.println("Longest Palindrome " + longestPalindrome);

    }
}
