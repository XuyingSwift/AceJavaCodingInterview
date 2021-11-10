package main.DataStructure.Strings;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String s = "5F3Z-2e=9-w";
        int k = 4;
        System.out.println(format(s, k));
    }

    public static String format(String s, int k) {
        s = s.replaceAll("\\-","").toUpperCase();
        StringBuilder filter = new StringBuilder();
        int count = 0;
        for (int i = s.length() -1; i>=0; i--) {
            char ch = s.charAt(i);
            filter.insert(0, ch);
            count++;
            if (i>0 && count == k) {
                filter.insert(0, '-');
                count = 0;
            }
        }
        return filter.toString();
    }
}
