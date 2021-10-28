package main.Compnay.Google;

import java.util.*;

public class GenerateLongestPalindromicString {

    public static void main(String[] args) {
        // the definition of
        String[] s = {"ab", "ba", "bb", "bb", "cc"};
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
        System.out.println(getP(s));

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

    public static String getP(String[] s){
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = Arrays.asList(s);

        for (String item: list) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            }else{
                map.put(item, 1);
            }
        }

        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();

        String middle = "";
        HashSet<String> set = new HashSet<>(map.keySet());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String re = reverse(entry.getKey());

            if (entry.getKey().equals(re) && entry.getValue() == 1) {
                middle = entry.getKey();
            }else if (entry.getKey().equals(re) && entry.getValue() > 1) {
                left.add(entry.getKey());
                right.add(re);
            } else if (set.contains(re)) {
                left.add(entry.getKey());
                right.add(re);
                set.remove(entry.getKey());
                set.remove(re);
            }

        }
        String ans = String.join("", left);
        ans = ans + middle;
        Collections.reverse(right);
        ans = ans + String.join("", right);
        return ans;
    }

}
