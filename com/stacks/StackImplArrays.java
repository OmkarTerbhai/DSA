package com.stacks;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StackImplArrays<T> {
    int currSize;
    T[] st;
    int top;

    public StackImplArrays(Class<T> clazz, int currSize) {
        top = -1;
        st = (T[]) Array.newInstance(clazz, currSize);
        this.currSize = 0;
    }

    public void push(T ele) throws Exception {
        if(currSize == st.length) {
            throw new Exception("Stack is full");
        }
        currSize++;
        top++;
        st[top] = ele;
    }

    @Override
    public String toString() {
        return "StackImplArrays{" +
                "st=" + Arrays.toString(st) +
                '}';
    }

    public T pop() throws Exception {
        if(currSize == 0)
            throw new Exception("Stack is empty");
        currSize--;
        T ret = st[top];
        st[top] = null;
        top--;
        return ret;
    }

    public T peek() throws Exception {
        if(currSize == 0)
            throw new Exception("Stack is empty");

        return st[top];
    }
}
