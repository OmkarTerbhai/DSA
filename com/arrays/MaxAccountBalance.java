package com.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MaxAccountBalance {
    public static void main(String[] args) {

    }

    private static int solver(int[] arr, int k) {
        int iSum = 0;
        int i = 0;
        Arrays.sort(arr);
        while(i < arr.length && k > 0) {
            if(arr[i] < 0) {
                arr[i] = -arr[i];
                k--;
            }
            i++;
        }
        i = 0;
        while(i < arr.length && k > 0) {
                arr[i] = -arr[i];
                k--;
                i++;

        }

        for(int ele : arr) {
            iSum += ele;
        }
        return iSum;
    }
}
