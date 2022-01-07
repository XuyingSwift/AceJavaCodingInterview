package main.newYear2022.Jan;

public class Jan7th {
    public static void main(String[] args) {
        int a = -100;
        int b = 234;
        int c = 0;
        String toy = String.valueOf(-a);
        String t = new StringBuilder(toy).append("-").reverse().toString();
        System.out.println(t);
        System.out.println(toy);
        System.out.println(reverseNumbers(a));
        System.out.println(reverseNumbers(b));
        System.out.println(reverseNumbers(c));
    }
    public static int reverseNumbers(int x) {
        String result = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
                : new StringBuilder(String.valueOf(x)).reverse().toString();
        try{
            return Integer.parseInt(result);
        }catch (Exception e) {
            return 0;
        }
    }
}
