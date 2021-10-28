package main.DataStructure.LinkedList;

public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public String toString() {
        return " " + value;
    }
}
