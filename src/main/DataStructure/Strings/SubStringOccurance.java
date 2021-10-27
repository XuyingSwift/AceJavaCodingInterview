package main.DataStructure.Strings;

import java.util.*;

public class SubStringOccurance {
    public static void main(String[] args) {

        System.out.println("find the freq of a char of a string");
        System.out.println(findFreq("BGRBGRRRRR", 'R'));
        int r = findFreq("RGBRGBRGBBBBB", 'R');
        int g = findFreq("RGBRGBRGBBBBB", 'G');
        int b = findFreq("RGBRGBRGBBBBB", 'B');
        System.out.println("r " + r);
        System.out.println("g " + g);
        System.out.println("b " + b);
        int smallest = r<g?(g<b?g:b):(r<b?r:b);

        System.out.println(smallest);
    }

    public static int findFreq(String s, Character c) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i =0; i<s.length(); i++) {
            if (freq.containsKey(s.charAt(i))){
                freq.put(s.charAt(i), freq.get(s.charAt(i)) + 1);
            }else {
                freq.put(s.charAt(i), 1);
            }
        }
        return freq.get(c);
    }
}
