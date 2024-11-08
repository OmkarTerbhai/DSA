package com.stacks;

public class QueueDriver {
    public static void main(String[] args) throws Exception {
        QueueImplArrays<Integer> queue = new QueueImplArrays<>(Integer.class, 10);

        queue.enqueue(21);
        queue.enqueue(33);
        queue.enqueue(44);
        queue.dequeue();
        queue.enqueue(22);

        System.out.println(queue.peek());
    }
}
