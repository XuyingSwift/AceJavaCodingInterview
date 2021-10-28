package main.DataStructure.LinkedList;

public class Queue {
    public Node head;
    public Queue() {
        this.head = null;
    }

    public void enqueue(int x) {
        Node newNode = new Node(x);
        if(head == null) {
            head = newNode;
        }else{
            Node prt = head;
            while (prt.next != null) {
                prt = prt.next;
            }
            prt.next = newNode;
        }
        newNode.next = null;
    }

    public int dequeue() throws Exception{
        if (head == null) {
            throw new Exception("remove from empty list");
        }
        int result = head.value;
        head = head.next;
        return result;
    }
}
