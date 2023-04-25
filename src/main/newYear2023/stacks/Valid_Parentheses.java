package main.newYear2023.stacks;

import java.util.HashMap;
import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args)
    {
        String s1 = "()";
        System.out.println(valid_parentheses(s1));
        String s2 = "()[]{}";
        System.out.println(valid_parentheses(s2));
        String s3 = "(]";
        System.out.println(valid_parentheses(s3));
    }

    public static boolean valid_parentheses(String str)
    {
        Stack<Character> char_stack = new Stack<>();
        HashMap<Character, Character> valid_map = new HashMap<>();
        valid_map.put(')', '(');
        valid_map.put(']', '[');
        valid_map.put('}', '{');

        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            // if the current char is a closing bracket
            if (valid_map.containsKey(c))
            {
                // get the top element of the stack if the stack is empty, set a dump value
                char topItem = char_stack.empty() ? '#' : char_stack.pop();

                // is the topItem is not matching
                if (topItem != valid_map.get(c)){
                    return false;
                }
            } else {
                // If it was an opening bracket, push it to stack
                char_stack.push(c);
            }
        }
        // because the stack only contains the open brackets, if it is not empty, then the string is invalid
        return char_stack.isEmpty();
    }
}
