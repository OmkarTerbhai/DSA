package com.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianInDataStream {
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;

    public MedianInDataStream() {
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //By default add to left queue
        leftHeap.add(num);

        if(!leftHeap.isEmpty() && !rightHeap.isEmpty()) {
            //Heaps validity check
            if(leftHeap.peek() > rightHeap.peek()) {
                rightHeap.add(leftHeap.poll());
            }
        }

        //Heaps size disparity
        if(leftHeap.size() > rightHeap.size() + 1) {
            rightHeap.add(leftHeap.poll());
        }
        else if(rightHeap.size() > leftHeap.size() + 1) {
            leftHeap.add(rightHeap.poll());
        }
    }

    public double findMedian() {
        if(leftHeap.size() > rightHeap.size()) {
            return (double) leftHeap.peek();
        }
        if(rightHeap.size() > leftHeap.size()) {
            return (double) rightHeap.peek();
        }

        return (double) ((leftHeap.peek() + rightHeap.peek()) / 2.0D);
    }

    public static void main(String[] args) {
        MedianInDataStream md= new MedianInDataStream();

        md.addNum(1);
        md.addNum(2);
        md.addNum(3);
        md.addNum(4);

        System.out.println(md.findMedian());

    }
}
