package com.stacks;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author:- omkar
 */
public class StackImpl {
    class Node {
        private int data;
        private Node next;

        public int getData() {
            return this.data;
        }
        public Node(int data) {
            this.data = data;
            if(Objects.nonNull(head)) {
                this.next = head;
                head = this;
            }
            else
                this.next = null;
        }
    }

    Node head = null;

    public static void main(String[] args) {
        StackImpl obj = new StackImpl();
        Scanner in = new Scanner(System.in);
        System.out.println("-----------------------------");
        while(true) {
            System.out.println("Choose 1.Push or 2.Pop or 3.Peek");
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter data to be pushed: ");
                    int data = in.nextInt();
                    obj.push(data);
                }

                case 2 -> {
                    Node ret = obj.pop();
                    System.out.println("Data Popped: " + ret.getData());
                }

                case 3 -> {
                    int iRet = obj.peek();
                    System.out.println("Data at top: " + iRet);
                }

                default -> {
                    System.out.println("Wrong Choice...");
                    return;
                }
            }
        }
    }

    /**
     * Method to push data into the stack
     *
     * @param data
     */
    private void push(int data) {



        /*Handling stack with only one element and full stack */
        if(Objects.nonNull(head)) {
            Node newN = new Node(data);
        }
        /*Handling empty stack*/
        else {
            head = new Node(data);
        }
    }

    /**
     * Method to pop and return the node at top
     *
     * @return
     */
    private Node pop() {
        Node ret  = null;
        if(Objects.nonNull(head)) {
            ret = head;
            head = head.next;
            ret.next = null;
        }
        else {
            throw new RuntimeException("Stack is Empty");
        }

        return ret;
    }

    private int peek() {
       if(Objects.nonNull(head)) {
           return head.data;
       }
       else {
           throw new RuntimeException("Stack is Empty");
       }
    }
}
