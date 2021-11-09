package main.Compnay.Facebook;

import java.util.*;

public class FindTheLongestVocationTime {

    public static void main(String[] args) {
        String[] str = new String[]{"W", "H", "H", "W"};
        int k = 2;
        System.out.println(longestV(str));
        String[] test1= new String[]{"W", "H"};
        System.out.println(longestV(test1));
    }

    public static int longestV(String[] s) {
        List<String> list = Arrays.asList(s);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i =0; i<s.length; i++) {
            if(map.containsKey(s[i])) {
                map.put(s[i], map.get(s[i]) + 1);
            }else {
                map.put(s[i], 1);
            }
        }
        int max = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey() == "W" && entry.getValue() >= 2) {
                int first = list.indexOf(entry.getKey());
                int last = list.lastIndexOf(entry.getKey());
                max = last - first + 1;
            }
        }

        return max;
    }
}
