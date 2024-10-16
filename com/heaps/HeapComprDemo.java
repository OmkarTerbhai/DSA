package com.heaps;

import java.util.PriorityQueue;

class Node {
    int iNo;
    int row;
    int col;

    Node(int iNo, int row, int col) {
        this.iNo = iNo;
        this.row = row;
        this.col = col;
    }
}
public class HeapComprDemo {

    public static void main(String[] args) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.iNo - b.iNo);

        pq.add(new Node(10, 0, 0));
        pq.add(new Node(20, 0, 0));
        pq.add(new Node(5, 0, 0));

        System.out.println(pq.peek().iNo);
    }
}
