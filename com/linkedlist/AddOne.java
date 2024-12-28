package com.linkedlist;

public class AddOne {

    public static void main(String[] args) {
        Node n = new Node(9);

        Node ret = addOne(n);
    }
    public static Node addOne(Node head) {
        head = reverseList(head);
        int carry = 1;

        Node temp = head;
        Node temp2 = head;
        while(temp != null) {
            int iSum = temp.data + carry;
            temp.data = iSum % 10;
            carry = iSum / 10;
            temp2 = temp;
            temp = temp.next;
        }
        if(carry != 0) {
            temp2.next = new Node(carry);

        }

        Node ret = reverseList(head);
        return ret;

    }

    public static Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = curr.next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
