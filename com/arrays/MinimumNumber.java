package com.arrays;

public class MinimumNumber {
    public static void main(String[] args) {
        int[] arr = {18, 23, 45, 66, 12};
        System.out.println("Minimum vaue is : " + findMinimum(arr));
    }

    private static int findMinimum(int[] arr) {
        int iMin = Integer.MAX_VALUE;

        for(int ele : arr) {
            if(ele < iMin) {
                iMin = ele;
            }
        }
        return iMin;
    }
}
