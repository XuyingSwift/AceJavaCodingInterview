package main.DataStructure.LinkedList;

public class Driver {
    public static void main(String[] args) throws Exception {
        Queue q = new Queue();
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.println(q.dequeue());

        LinkedList list = new LinkedList();
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtHead(4);
        list.printLinkedList();
        System.out.println(list.getSum(list.head));
        System.out.println(list.sum());
    }
}
