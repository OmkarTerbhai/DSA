package com.stacks;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
public class StackImplLinkedList<T> {
    int currSize;
    Node<T> head;


    public void push(T ele) {
        if(head == null) {
            head = new Node<>(ele);
        }
        else {
            Node<T> temp = new Node<>(ele);
            temp.next = head;
            head = temp;
        }
    }

    public T pop() throws Exception {
        T tRet = null;
        if(head == null) {
            throw new Exception("Stack is Empty");
        }
        else {
            tRet = head.data;
            head = head.next;
        }
        return tRet;
    }

    public T peek() throws Exception {
        if(head == null) {
            throw new Exception("Stack is Empty");
        }
        return head.data;
    }
}
