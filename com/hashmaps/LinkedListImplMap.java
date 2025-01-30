package com.hashmaps;



import java.util.Objects;

/**
 * @author: - omkar
 */
class Node<T, V> {
    T key;

    V value;
    Node<T, V> next;

    public Node(){}
    public Node(T key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
public class LinkedListImplMap<T, V> {


    Node<T, V> head;
    void addLast(T data, V value) {
        Node<T, V> newN = new Node<T,V>(data, value);
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

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.key + "->");
            temp = temp.next;
        }
        System.out.print("NULL");
    }


}

