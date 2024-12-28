package com.stacks;

import java.util.Arrays;
import java.util.Stack;

public class PrevLesserElement {

    public static void main(String[] args) {
        int[] arr = {39, 27, 11, 4, 24, 32, 32, 1};
        System.out.println(Arrays.toString(prevSmaller(arr)));
    }
    public static int[] prevSmaller(int[] A) {
        int[] iAns = new int[A.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < A.length; i++) {
            int ele = A[i];
            while(!st.isEmpty() && st.peek() > ele) {
                st.pop();
            }
            if(st.isEmpty()) {
                iAns[i] = -1;
            }
            else {
                iAns[i] = st.peek();
            }
            st.push(ele);
        }
        return iAns;
    }
}
