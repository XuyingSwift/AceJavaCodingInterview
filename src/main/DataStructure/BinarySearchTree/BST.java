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


}
