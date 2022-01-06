package main.newYear2022.Jan;

import main.DataStructure.LinkedList.LinkedList;
import main.DataStructure.LinkedList.Node;

public class Jan6th {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertAtHead(3);
        l1.insertAtHead(4);
        l1.insertAtHead(2);

        l1.printLinkedList();
        System.out.println();

        LinkedList l2 = new LinkedList();
        l2.insertAtHead(4);
        l2.insertAtHead(6);
        l2.insertAtHead(5);
        l2.printLinkedList();



    }

    public static Node addTwoNums(Node l1, Node l2) {
        Node c1 = l1;
        Node c2 = l2;
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int carry = 0;

        while (c1 != null || c2 != null) {
           int x = c1 != null ? c1.value : 0;
           int y = c2 != null ? c2.value : 0;
           int sum = carry + x + y;
           carry = sum / 10;
           current.next = new Node(sum % 10);
           current = current.next;
           if (c1 != null) c1 = c1.next;
           if (c2 != null) c2 = c2.next;
        }
        if (carry > 0) {
            current.next = new Node(carry);
        }
        return dummyHead.next;
    }
}
