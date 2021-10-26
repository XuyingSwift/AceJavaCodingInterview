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
        Node n1 = new Node(7);
        Node n2 = new Node(3);
        Node r1 = bst.findLowestCommonAncestor(bst.root, n1, n2);
        System.out.println("Lowest common Ancestor " + r1.value);

        Node n3 = new Node(1);
        Node n4 = new Node(3);
        Node r2 = bst.findLowestCommonAncestor(bst.root, n3, n4);
        System.out.println("Lowest common Ancestor " + r2.value);
    }

}
