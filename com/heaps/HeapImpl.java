package com.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
2 41
0
2 18
2 30
0
2 34
0
2 5
2 30
0
2 17
0
2 4
0
0
2 21
2 2

 */
public class HeapImpl {
    public static void main(String[] args) {
        int[] a = {10, 5, 6, 2};
        int[] b = {12, 7, 9};

        int[] iRes = mergeHeaps(a, b, a.length, b.length);
        System.out.println(Arrays.toString(iRes));
    }

    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        ArrayList<Integer> heap = new ArrayList<>(n + m);

        for(int ele : a) {
            heap.add(ele);
        }
        for(int ele : b) {
            heap.add(ele);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int ele : heap) {
            addEle(ans, ele);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void addEle(List<Integer> heap, int ele) {
        heap.add(ele);
        upheapify(heap, heap.size() - 1);
    }

    private static int removeEle(List<Integer> heap) {
        if(heap.isEmpty()) return -1;
        int iRet = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        downheap(heap, 0);
        return iRet;
    }

    private static int removeEleAtIdx(List<Integer> heap, int idx) {
        int iRet = heap.get(idx);
        heap.set(idx, Integer.MAX_VALUE);
        downheap(heap, idx);
        heap.remove(heap.size()-1);
        return iRet;
    }

    private static void upheapify(List<Integer> heap, int i) {
        if(i == 0) return;

        if(heap.get(i) > heap.get(getParent(i))) {
            int a = heap.get(i);
            heap.set(i, heap.get(getParent(i)));
            heap.set(getParent(i), a);
        }
        upheapify(heap, getParent(i));
    }

    private static void downheap(List<Integer> heap, int idx) {
        int iMin = Integer.MAX_VALUE;
        int minIdx = -1;
        if((getLeftChild(idx) < heap.size() && getRightChild(idx) < heap.size()) && (heap.get(idx) > heap.get(getLeftChild(idx)) || heap.get(idx) > heap.get(getRightChild(idx)))) {
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
