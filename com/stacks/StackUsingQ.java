package com.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQ {
    Queue<Integer> queue;

    public StackUsingQ() {
        queue = new LinkedList<>();
    }

    public void push(int ele) {
        queue.offer(ele);

        for(int i = 1; i < queue.size(); i++) {
            queue.offer(queue.remove());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int peek() {
        return queue.peek();
    }
}
