package com.heaps;

import java.util.ArrayList;
import java.util.List;

public class HeapImpl {
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();

        addEle(heap, 21);
        addEle(heap, 11);
        addEle(heap, 7);

        System.out.println(heap);
    }

    private static void addEle(List<Integer> heap, int ele) {
        heap.add(ele);
        upheapify(heap, heap.size() - 1);
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

    private static int getParent(int idx) {
        return (idx - 1) / 2;
    }
}
