package main.Java11Exam.charpter14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsingWrapperClasses {

    // With autoboxing, the compiler automatically converts a primitive to the corresponding wrapper
    // Unsurprisingly, unboxing is the process in which the compiler automatically converts a wrapper class back to a primitive.

    public static void main(String[] args) {
        // autoboxing as the int primitive is autoboxed into an Integer object
        Integer pounds = 120;
        Character letter = "robot".charAt(0);
        // unboxing
        char r = letter;

        var heights = new ArrayList<Integer>();
        heights.add(null);
        //int h = heights.get(0);// NUll Pointer Exception
        //System.out.println(h);

        List<Integer> numbers = new ArrayList<>();
        // autoboxing int to Integer
        numbers.add(1);
        numbers.add(Integer.valueOf(3));
        numbers.add(Integer.valueOf(5));
        // remove the item at index 1
        numbers.remove(1);
        numbers.remove(Integer.valueOf(5));
        System.out.println(numbers);

        // the diamond operator is a shorthand notation that allows your to omit the generic type from the right side of a statement when the type can be inferred.
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<Long, List<Integer>> mapoflist = new HashMap<>();


    }
}
