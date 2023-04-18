package main.newYear2023.April13th;

public class validPalindrome {
    public static void main(String[] args)
    {
        System.out.println("Let's practice ");
        String s = "abba";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String str)
    {
        int l_pointer = 0;
        int r_pointer = str.length() - 1;

        while (l_pointer <= r_pointer) {
            if (!Character.isLetterOrDigit(str.charAt(l_pointer)))
            {
                l_pointer ++;
            } else if (!Character.isLetterOrDigit(str.charAt(r_pointer))){
                r_pointer --;
            } else if (str.charAt(l_pointer) != str.charAt(r_pointer))
            {
                return false;
            }
            l_pointer ++;
            r_pointer --;
        }
        return true;
    }
}
