package com.arrays;

import java.util.Scanner;

public class ArraysDemo {
    public static void main(String[] args) {

        int[] arr = {400, 500, 300, 200, 100};

        int[] arr2 = {10, 34, 56, 23, 12};

        System.out.println("------Swapping references in another method---------------");
        swap(arr, arr2);
        printArray(arr, arr.length - 1);
        printArray(arr2, arr2.length - 1);

        System.out.println("-------------Swapping first and last elements-------------");
        swap2(arr, arr2);
        printArray(arr, arr.length - 1);
        printArray(arr2, arr2.length - 1);
    }

    private static void printArray(int[] a, int n) {
        if(n == -1) {
            System.out.println();
            return;
        }

        printArray(a, n-1);
        System.out.print(a[n] + " ");
    }
    private static void swap(int[] a, int[] b) {
        int[] temp = b;
        b = a;
        a = temp;
    }

    private static void swap2(int[] a, int[] b) {
        a[0] = 99;
        a[a.length - 1] = 99;

        b[0] = 99;
        b[b.length - 1] = 99;
    }
}
