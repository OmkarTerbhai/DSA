package com.stacks;

import java.util.Arrays;
import java.util.Stack;

public class PrevGreaterEle {

    public static void main(String[] args) {
        int[] nums = {10,4,2,20,40,12,30};
        System.out.println(Arrays.toString(solver(nums)));
    }

    private static int[] solver(int[] nums) {
        int[] iAns = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < nums.length; i++) {
            int ele = nums[i];

            while(!st.isEmpty() && st.peek() <= ele) {
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
