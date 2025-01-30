package com.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low >= high) return;
        
        int partitionIdx = quickSortHelper(arr, low, high);
        quickSort(arr, low, partitionIdx);
        quickSort(arr, partitionIdx+1, high);
    }

    private static int quickSortHelper(int[] arr, int low, int high) {
        int pivotIdx = low;
        int n = arr.length;
        int pivot = arr[pivotIdx];

        int left = 1, right = n - 1;

        while(left < right) {
            while(left < arr.length && arr[left] <=  pivot) {
                left++;
            }

            while(right > 0 && arr[right] > pivot) {
                right--;
            }

            if(left < right) {
                int sw = arr[left];
                arr[left] = arr[right];
                arr[right] = sw;
            }
        }
        int sw = arr[pivotIdx];
        arr[pivotIdx] = arr[right];
        arr[right] = sw;
        return right;
    }
}
