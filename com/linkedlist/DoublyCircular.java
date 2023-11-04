package com.linkedlist;

import java.util.Objects;

class Node2 {
    int data;
    Node2 next;
    Node2 prev;

    public Node2(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class DoublyCircular {
    Node2 head;
    Node2 tail;
    void addFirst(int data) {
        Node2 newN = new Node2(data);
        if(Objects.isNull(head)) {
            head = newN;
            tail = newN;
            head.next = tail;
            tail.prev = head;
        }
        else {
            newN.next = head;
            head.prev = newN;
            head = head.prev;
            tail.next = head;
            head.prev = tail;
        }
    }

    void addLast(int data) {
        Node2 newN = new Node2(data);
        if(Objects.isNull(head)) {
            head = newN;
            tail = newN;
            head.next = tail;
            tail.prev = head;
        }
        else {
            tail.next = newN;
            newN.prev = tail;
            tail = tail.next;
            head.prev = tail;
            tail.next = head;
        }
    }

    void addAtPos(int data, int pos) {
        Node2 newN = new Node2(data);
        if(pos == 1) {
            this.addFirst(data);
        }
        else {
            Node2 temp = head;
            for(int i = 1; i < pos-1; i++) {
                temp = temp.next;
            }
            newN.next = temp.next;
            temp.next.prev = newN;
            temp.next = newN;
            newN.prev = temp;
        }
    }

    public static void main(String[] args) {
        DoublyCircular dll = new DoublyCircular();

        dll.addFirst(11);
        dll.addLast(31);
        dll.addAtPos(21, 2);
        dll.addAtPos(9, 1);

        dll.insertRec(34, 2);

        dll.display();
        System.out.println();
        dll.displayReverse();
    }

    private void insertRec(int data, int pos) {
        Node2 temp = head;
        insertRecr(data, pos-2, temp);
    }

    private void insertRecr(int data, int pos, Node2 temp) {
        if(pos == 0) {
            Node2 newN = new Node2(data);
            newN.next = temp.next;
            temp.next.prev = newN;
            temp.next = newN;
            newN.prev = temp;
        }
        else
            insertRecr(data, pos-1, temp.next);
    }

    private void display() {
        Node2 temp = head;
        do {
            System.out.print(temp.data + "->");
            temp = temp.next;

        }while (temp != head);

    }

    private void displayReverse() {
        Node2 temp = tail;
        do {
            System.out.print(temp.data + "->");
            temp = temp.prev;

        }while (temp != tail);
    }



}
