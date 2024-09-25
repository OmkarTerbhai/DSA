package com.heaps;

import java.util.ArrayList;
import java.util.List;

public class HeapImpl {
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();

        addEle(heap, 21);
        addEle(heap, 11);
        addEle(heap, 7);
        addEle(heap, 5);

        removeEle(heap);

        System.out.println(heap);
    }

    private static void addEle(List<Integer> heap, int ele) {
        heap.add(ele);
        upheapify(heap, heap.size() - 1);
    }

    private static int removeEle(List<Integer> heap) {
        int iRet = heap.remove(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.get(heap.size()-1));
        downheap(heap, 0);
        return iRet;
    }

    private static void upheapify(List<Integer> heap, int i) {
        if(i == 0) return;

        if(heap.get(i) < heap.get(getParent(i))) {
            int a = heap.get(i);
            heap.set(i, heap.get(getParent(i)));
            heap.set(heap.get(getParent(i)), a);
        }
        upheapify(heap, getParent(i));
    }

    private static void downheap(List<Integer> heap, int idx) {
        int iMin = Integer.MAX_VALUE;
        int minIdx = -1;
        if(heap.get(idx) > heap.get(getLeftChild(idx)) || heap.get(idx) > heap.get(getRightChild(idx))) {
            if(heap.get(getLeftChild(idx)) < heap.get(getRightChild(idx))) {
                int sw = heap.get(idx);
                heap.set(idx, heap.get(getLeftChild(idx)));
                heap.set(getLeftChild(idx), sw);
                minIdx = getLeftChild(idx);
                downheap(heap, minIdx);
            }
            else {
                int sw = heap.get(idx);
                heap.set(idx, heap.get(getRightChild(idx)));
                heap.set(getRightChild(idx), sw);
                minIdx = getRightChild(idx);
                downheap(heap, minIdx);
            }

        }
     }

    private static int getParent(int idx) {
        return (idx - 1) / 2;
    }

    private static int getRightChild(int idx) {
        return (2 * idx) + 2;
    }

    private static int getLeftChild(int idx) {
        return (2 * idx) + 1;
    }
}
