package com.stacks;

import java.lang.reflect.Array;

public class QueueImplArrays<T> {
    int currSize;
    T[] arr;
    int start;
    int end;

    public QueueImplArrays(Class<T> clazz, int size) {
        arr = (T[]) Array.newInstance(clazz, size);
        currSize = 0;
        start = -1;
        end = -1;
    }

    public void enqueue(T ele) throws Exception {
        if(currSize == arr.length)
            throw new Exception("Queue is full");
        if(currSize == 0) {
            start++;
        }
        currSize++;
        end = (end + 1) % arr.length;
        arr[end] = ele;
    }

    public T dequeue() throws Exception {
        if(currSize == 0) {
            start = -1;
            end = -1;
            throw new Exception("Queue is empty");
        }

        currSize--;
        T tRet = arr[start];
        arr[start] = null;
        start = (start + 1) % arr.length;
        return tRet;
    }

    public T peek() throws Exception {
        if(currSize == 0) {
            start = -1;
            end = -1;
            throw new Exception("Queue is empty");
        }
        return arr[start];
    }
}
