package main.DataStructure.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BST {
    // reference to the root node
    public Node root;

    // reference to the parent node
    public Node myParent;

    // reference to a list to store all leaf nodes
    List<List<Integer>> leaves;

    // constructor
    public BST() {
        root = null;
        this.leaves = new ArrayList<>();
    }

    // insert a node into a BST

    // search a node in a BST
    public Node findNode(int x){
        // use auxiliary traversal variable
        // always start at the root node
        Node currentNode = root; // so we will not lose root node
        Node preNode = root; // remember the previous node for insertion
        while (currentNode != null) {
            if (x == currentNode.value) {
                // we found the x
                // set myParent
                myParent = preNode;
                return currentNode;
            }else if ( x < currentNode.value){
                // update preNode
                preNode = currentNode;
                // continue search in left subtree
                currentNode = currentNode.left;
            }else {
                // update preNode
                preNode = currentNode;
                currentNode = currentNode.right;
            }
        }

        // when we reach here, x is not in bst
        myParent = preNode;
        return null;
    }

    // insert a node in
    public void add(int x) {
        Node helpNode;

        if (root == null) {
            root = new Node(x);
            return;
        }

        helpNode = findNode(x);
        if (helpNode != null) {
            return;
        }

        Node newX = new Node(x);
        if (x < myParent.value) {
            myParent.left = newX;
        }else{
            myParent.right = newX;
        }
    }

    // print traverse the tree inorder
    public void inOrder(Node node){
        if (node == null) {return;}
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public int getHeight(Node node) {
        if (node == null) {return -1;}
        int leftH = getHeight(node.left);
        int rightH = getHeight(node.right);

        int currHeight = Math.max(leftH, rightH) + 1;

        if (this.leaves.size() == currHeight) {
            this.leaves.add(new ArrayList<>());
        }
        this.leaves.get(currHeight).add(node.value);

        return currHeight;
    }

    public List<List<Integer>> getLeaves(Node node) {

        getHeight(node);

        return this.leaves;
    }

    // Algorithm:
    /*
    * 1. Create a recursive function that takes a node and two values n1 and n2,
    * 2: if the value of the current node is less than n1 and n2, then LCA lies in the right subtree
    *    call the recursive function for the right subtree
    * 3: if the value fo the current node is more than n1 and n2, then LCS lies in the left subtree
    *    call the recursive function for the left subtree
    * 4: if both the above cases are false then, return the current node as lca
    * */

    public Node findLowestCommonAncestor(Node currentNode, Node n1, Node n2){
        if (currentNode == null) {
            return null;
        }

        if (currentNode.value > n1.value && currentNode.value > n2.value) {
            return findLowestCommonAncestor(currentNode.left, n1, n2);
        }else if (currentNode.value < n1.value && currentNode.value < n2.value) {
            return findLowestCommonAncestor(currentNode.right, n1, n2);
        }else {
            return currentNode;
        }
    }

}
