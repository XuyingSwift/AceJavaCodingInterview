package main.algorithms.BreadthFristSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class findAllPermutations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> result = findPermutations(list);
        System.out.println(result);
    }

    public static List<List<Integer>> findPermutations(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing permutations and add the current number to create new permutations
            int n = permutations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();
                // create a new permutation by adding the current number at every position
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currentNumber);
                    if (newPermutation.size() == nums.size())
                        result.add(newPermutation);
                    else
                        permutations.add(newPermutation);
                }
            }
        }
        return result;
    }
}
