package com.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {23, 67, 1, 12};
        int[] res = selectionSort(arr);

        System.out.println(Arrays.toString(res));
    }

    private static int[] selectionSort(int[] arr) {
        int x = 0;

        while(x < arr.length-1) {
            int minIndex = findMinimum(arr, x);

            if(x != minIndex) {
                int temp = arr[x];
                arr[x] = arr[minIndex];
                arr[minIndex] = temp;
            }
            x++;
        }
        return arr;
    }

    private static int findMinimum(int[] arr, int start) {
           int iMin = arr[start];
           int iRet = start;
           for(int i = start+1; i < arr.length; i++) {
               if(iMin > arr[i]) {
                   iMin = arr[i];
                   iRet = i;
               }
           }
           return iRet;
    }
}
