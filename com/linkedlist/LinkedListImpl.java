package com.linkedlist;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author: - omkar
 */
class Node {
    int data;
    Node next;

    public Node(){}
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedListImpl {
    public Node head;
    Node tail;
    void addFirst(int data) {
        Node newN = new Node(data);
        if(Objects.isNull(head)) {
            head = newN;
        }
        else {
            newN.next = head;
            head = newN;
        }
    }

    public void addLast(int data) {
        Node newN = new Node(data);
        if(Objects.isNull(head)) {
            head = newN;
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newN;
        }
    }

    void addAtPos(int pos, int data) {
        Node newN = new Node(data);

        if(Objects.isNull(head)) {
            head = newN;
        }
        if(pos == 1) {
            this.addFirst(data);
        }
        else {
            Node temp = head;
            for(int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newN.next = temp.next;
            temp.next = newN;
        }
    }

    void deleteFirst() {
        if(Objects.isNull(head)) {
            return;
        } else if (Objects.isNull(head.next)) {
            head = null;
        }
        else {
            head = head.next;
        }
    }

    void deleteLast() {
        if(Objects.isNull(head)) {
            return;
        } else if (Objects.isNull(head.next)) {
            head = null;
        }
        else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    void deleteAtPos(int pos) {
        if (pos == 1) {
            this.deleteFirst();
        }
        else {
            Node temp = head;
            for(int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            Node del = temp.next;
            temp.next = del.next;
            del.next = null;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    private Node reverseLLIter(Node head) {
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

    private Node reverseLLIter2(Node head, int start, int end) {
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

    private Node reverseLLRecur(Node head) {

        if(null == head.next) {
            this.tail = head;
            return head;
        }
        Node ret = reverseLLRecur(head.next);
        ret.next = head;
        head.next = null;
        return head;
    }

    public Node reversePartialLL(Node head, int st, int end) {
      //Find start and end nodes
        Node start = head;
        Node endNode = head;
        Node preceding = head;
        for(int i = 1; i < st; i++) {
            if(i == st-1) preceding = start;
            start = start.next;
        }
        //Find endNode
        endNode = start;
        Node succeding = start;
        for(int i = 1; i <= end-st+1; i++) {
            if(i == end-1) endNode = succeding;
            succeding = succeding.next;
        }

        /*Reversing the desired part*/
        Node curr = start;
        Node prev = null;
        Node next = curr.next;

        while (curr != succeding) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        preceding.next = endNode;
        start.next = succeding;

        return head;
    }

    public static void main(String[] args) {
        LinkedListImpl impl = new LinkedListImpl();

        impl.addLast(1);
        impl.addLast(2);
        impl.addLast(3);
        impl.addLast(4);
        impl.addLast(5);


        impl.head = impl.reversePartialLL(impl.head, 2, 4);

        impl.display();
    }
}
