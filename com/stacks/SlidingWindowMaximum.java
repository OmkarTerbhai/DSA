package com.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowMaximum {
    private static int[] solver(int[] nums, int k) {
        List<Integer> li = new ArrayList<>();

        int n = nums.length;
        for(int i = 0; i <= n - k; i++) {
            int iMax = Integer.MIN_VALUE;
            for(int j = i; j < (i+k); j++) {
                iMax = Math.max(iMax, nums[j]);
            }
            li.add(iMax);
        }
        int[] iAns = new int[li.size()];
        for(int a = 0; a < li.size(); a++) {
            iAns[a] = li.get(a);
        }

        return iAns;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(solver(arr, 3)));
    }
}
