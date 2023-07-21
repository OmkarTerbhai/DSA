package com.arrays;

public class ArrayQuestions1 {
    public static void main(String[] args) {
        int[] arr = {34, 55, 56, 89, 78};
        rotateArray(arr, 16);
        printArray(arr, arr.length-1);
    }

    private static void rotateArray(int[] arr, int k) {
         k %= arr.length;
         if(k == arr.length) return;
         int tempK = k;

         int pivot = (arr.length) - k;
         int lastPopulated = pivot - 1;

         //Place elements to be rotated in temp array;
        int a = 0;
        int[] temp = new int[k];

        for(int i = pivot; i<= arr.length-1; i++) {
            temp[a] = arr[i];
            a++;
        }

        //Shift remaining elements to the right
        for(int i = lastPopulated; i >= 0; i--) {
            arr[i+k] = arr[i];
        }

        //Replace temp elements in main array
        for(int i = 0; i <= temp.length-1; i++) {
            arr[i] = temp[i];
        }
    }

    public static void printArray(int[] a, int n) {
        if(n == -1) {
            System.out.println();
            return;
        }

        printArray(a, n-1);
        System.out.print(a[n] + " ");
    }
}
