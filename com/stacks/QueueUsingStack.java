package com.stacks;

import java.util.Queue;
import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();


    }

    public void enqueue(int ele) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(ele);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int dequeue() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }
}
