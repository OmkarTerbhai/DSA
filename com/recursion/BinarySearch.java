package com.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 5, 12, 34, 45, 90};
        System.out.println("Element is present at index: " + binarySearch(0, arr.length-1, 80, arr));

    }

    static int binarySearch(int start, int end, int target, int[] arr) {
        if(start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if(arr[mid] == target) {
            return mid;
        }
        else if(arr[mid] > target) {
            return binarySearch(start, mid-1, target, arr);
        }
        else {
            return binarySearch(mid+1, end, target, arr);
        }


    }
}
