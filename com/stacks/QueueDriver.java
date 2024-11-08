package com.stacks;

public class QueueDriver {
    public static void main(String[] args) throws Exception {
        QueueUsingStack q = new QueueUsingStack();

        q.enqueue(5);
        q.enqueue(4);
        q.enqueue(2);
        q.dequeue();
        q.enqueue(1);

        System.out.println(q.peek());
    }
}
