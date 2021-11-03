package main.Java11Exam.charpter14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class MethodReference {

    /**
     * A method reference and a lambda behave the same way at runtime
     * you can pretend the compiler turns your method references into lambdas for you.
     * There are four formats for method references;
     * 1: static method
     * 2: instance method on a particular instance
     * 3: Instance methods on a parameter to be determined at runtime
     * 4: constructor
     */

    static class Penguin{
        public static Integer countBabies(Penguin... cuties) {
            return cuties.length;
        }
    }



   public static void main(String[] args) {
       // static method
       Consumer<List<Integer>> methodReference = Collections::sort;
       Consumer<List<Integer>> lambda = x -> Collections.sort(x);

       // Calling instance methods on Particular object
       // A predicate is a functional interface that takes on parameter and returns a boolean
       var str = "abc";
       Predicate<String> methodRef = str::startsWith;
       Predicate<String> lam = s -> str.startsWith(s);

       var random = new Random();
       Supplier<Integer> sup = random::nextInt;
       Supplier<Integer> supplier = () -> random.nextInt();

       // Calling instance methods on a parameter
       Predicate<String> me = String::isEmpty;
       Predicate<String> la = s -> s.isEmpty();

       BiPredicate<String, String> m = String::startsWith;
       BiPredicate<String, String> l = (t, i) -> t.startsWith(i);

       // Calling Constructors
       Supplier<List<String>> m1 = ArrayList::new;
       Supplier<List<String>> l1 = () -> new ArrayList<>();

       Supplier<Integer> e = Penguin::countBabies;
       Supplier<Integer> e1 = () -> Penguin.countBabies();

       Function<Penguin, Integer> t = Penguin::countBabies;
       Function<Penguin, Integer> d = x -> Penguin.countBabies(x);

    }

}
