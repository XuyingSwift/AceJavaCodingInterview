package main.DataStructure.LinkedList;

public class LinkedList {
    Node head;

    public LinkedList() {
    }

    public void insertAtHead(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    public void printLinkedList() {
       while (head != null) {
           System.out.print(head.value + " ");
           head = head.next;

       }
    }

    public int getSum(Node node) {
        int solution, smallerSol;
        if (node == null) {
            solution = 0;
        } else{
            smallerSol = getSum(node.next);
            solution = node.value + smallerSol;
        }
        return solution;
    }

    public int sum() {
        int sum = 0;
        while (head != null) {
            System.out.println(head.value);
            sum = sum + head.value;
            head = head.next;
        }
        return sum;
    }

    public Node getHead() {
        return head;
    }

}
