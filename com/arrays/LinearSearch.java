package com.arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {18, 12, 9, 14, 77, 50};

        System.out.println("Element found at: " + linearSearch(arr, 14));
    }

    static int linearSearch(int[] arr, int target) {
        int iRet = -1;
        if(arr.length == 0) return iRet;

        for(int i = 0; i <= arr.length-1; i++) {
            if(target == arr[i])
                iRet = i;
        }

        return iRet;
    }
}
