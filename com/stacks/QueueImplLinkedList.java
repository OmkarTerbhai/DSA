package com.stacks;

class QueueNode<T> {
    T data;
    QueueNode<T> next;

    public QueueNode(T data) {
        this.data = data;
        this.next = null;
    }
}
public class QueueImplLinkedList<T> {
    QueueNode<T> front;
    QueueNode<T> back;

    public void enqueue(T ele) {
        if(front == null) {
            front = new QueueNode<>(ele);
            back = front;
        }
        else {
            QueueNode<T> temp = new QueueNode<>(ele);
            back.next = temp;
            back = back.next;
        }
    }

    public T dequeue() throws Exception {
        if(front == null) {
            throw new Exception("Queue is empty");
        }
        T tRet = front.data;
        front = front.next;
        if(front == null) {
            back = null;
        }

        return tRet;
    }

    public T peek() throws Exception {
        if(front == null) {
            throw new Exception("Queue is empty");
        }
        return front.data;
    }
}
