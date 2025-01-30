package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChocolateDistribution {

    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>(Arrays.asList(3 ,4 ,1 ,9 ,56 ,7 ,9 ,12));

        System.out.println(findMinDiff(li, 5));
    }
    public static int findMinDiff(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        if(m > n) return -1;

        int iAns = Integer.MAX_VALUE;

        for(int i = 0; i <= (n-m); i++) {
            iAns = Math.min(iAns, getMax(arr, i, i+m-1) - getMin(arr, i, i+m-1));
        }
        return iAns;
    }

    private static int getMin(List<Integer> li, int i, int j) {
        int iMin = Integer.MAX_VALUE;

        for(int a = i; a <= j; a++) {
            iMin = Math.min(iMin, li.get(a));
        }

        return iMin;
    }

    private static int getMax(List<Integer> li, int i, int j) {
        int iMax = Integer.MIN_VALUE;

        for(int a = i; a <= j; a++) {
            iMax = Math.max(iMax, li.get(a));
        }

        return iMax;
    }
}
