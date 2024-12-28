package com.arrays;

public class ArrayMirror {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 2};
        System.out.println(solve(arr));
    }

    private static boolean solve(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= nums.length) return false;
            if(i != nums[nums[i]]) return false;
        }
        return true;
    }
}
