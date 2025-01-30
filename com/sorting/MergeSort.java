package com.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void mergeSort(int arr[], int low, int high) {
        if(low >= high) return;

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge2Sorted(arr, low, mid, high);
    }

    private static void merge2Sorted(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low, right = mid+1;
        int i = 0;
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[i] = arr[left];
                left++;
                i++;
            }
            else {
                temp[i] = arr[right];
                right++;
                i++;
            }
        }

        while(left <= mid) {
            temp[i] = arr[left];
            left++;
            i++;
        }

        while(right <= high) {
            temp[i] = arr[right];
            right++;
            i++;
        }

        for(i = low; i <= high; i++) {
            arr[i] = temp[i-low];
        }
    }
}
