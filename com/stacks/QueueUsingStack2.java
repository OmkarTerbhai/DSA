package com.stacks;

import java.util.Stack;

public class QueueUsingStack2 {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStack2() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(int ele) {
        s1.push(ele);
    }

    public int dequeue() {
        if(!s2.isEmpty()) {
            return s2.pop();
        }
        else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    public int peek() {
        if(!s2.isEmpty()) {
            return s2.peek();
        }
        else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
}
