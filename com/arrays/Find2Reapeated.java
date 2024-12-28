package com.arrays;

import java.util.Arrays;

public class Find2Reapeated {
    public static void main(String[] args) {
        int[] arr = {2,4,2,4};

        System.out.println(Arrays.toString(twoRepeated(arr)));
    }
    public static int[] twoRepeated(int arr[]) {
        int[] iAns = new int[2];
        int i = 0;
        int n = arr.length;
        while(i < n) {

            if(i != arr[i]-1 && arr[i] < n && arr[i] != arr[arr[i]]) {
                int swp = arr[i];
                arr[i] = arr[arr[i]];
                arr[swp] = swp;
            }
            else {
                i++;
            }
        }
        int a = 0;
        for(int j = 0; j < n; j++) {

            if(j != arr[j]-1) {
                iAns[a] = arr[j];
                a++;

                if(a > 1) break;
            }
        }

        return iAns;
    }
}
