package main.Compnay.Google;

import java.util.*;

public class GenerateLongestPalindromicString {

    public static void main(String[] args) {
        // the definition of
        String[] s = {"ab", "ba", "bb", "bb", "cc", "cc"};
        findLongest(s);
        System.out.println();
        String[] s1 = {"bb", "bb", "bb", "bb"};
        findLongest(s1);
        System.out.println();
        String[] s2 = {"bb", "ba", "ba", "ba"};
        findLongest(s2);
        System.out.println();
        String[] s3 = {"bb", "bb", "aa", "aa"};
        findLongest(s3);
        //System.out.println(reverse("bbaa"));


        System.out.println();
        List<String> h = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i =0; i<s.length; i++) {
            String str = s[i];
            String r = reverse(str);
            if (!str.equals(r)) {
                set.add(s[i]);
            }else {
                h.add(s[i]);
            }
        }

        for (String ss : h) {
            System.out.println(ss);
        }
    }

    public static void findLongest(String[] s) {

        String ans = "";
        // from the given array
        List<String> temp = Arrays.asList(s);

        Set<String> set = new HashSet<>();
        for (int i = 0; i<s.length; i++) {
            set.add(s[i]);
        }

        if (set.size() == 1) {
            ans =String.join("", s);
            System.out.println(ans);
        }else {
            List<String> left = new ArrayList<>();
            List<String> right = new ArrayList<>();
            // String middle = "";
            List<String> middle = new ArrayList<>();


            for (String item : temp) {
                String r = reverse(item);
                if (set.contains(r)) {
                    left.add(item);
                    right.add(r);
                    set.remove(item);
                    set.remove(r);
                }
            }
            //System.out.println("left");
            if (left.size() == 1 && right.size() == 1) {
                ans = left.get(0);
                System.out.println(ans);
            }else{
                left.forEach(System.out::print);
                //System.out.println();
                //System.out.println();
                //System.out.println("right");
                Collections.reverse(right);
                right.forEach(System.out::print);
            }


        }

    }

    public static String reverse(String s) {
        String ans = "";
        for (int i = s.length() -1; i>= 0; i--) {
            ans = ans + s.charAt(i);
        }
        return ans;
    }

}
