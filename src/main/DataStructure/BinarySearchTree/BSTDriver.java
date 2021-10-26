package main.DataStructure.BinarySearchTree;

import java.util.List;

public class BSTDriver {

    List<List<Integer>> allLeaves;

    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(4);
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(6);
        bst.add(5);
        bst.add(7);

        bst.inOrder(bst.root);
        int h = bst.getHeight(bst.root);
        System.out.println("the height of the tree, node to its leave");
        System.out.println(h);

        List<List<Integer>> list = bst.getLeaves(bst.root);

        for (List<Integer> l : list) {
            l.forEach(System.out::print);
        }
    }

}
