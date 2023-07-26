package com.recursion;

public class FrogJump {
    public static void main(String[] args) {
        int iRet = findMinimumCost(0, 3, new int[] {10, 30, 40, 20});
        System.out.println("Minimum cost: " + iRet);
    }

    static int findMinimumCost(int i, int n, int arr[]) {
        if(i == n) return 0;
        if(i > n) return Integer.MAX_VALUE;
        int jJump = 0;
        int iJump = findMinimumCost(i+1, n, arr) + Math.abs(arr[i] - arr[i+1]);
        if(i+2 <= n)
            jJump = findMinimumCost(i+2, n, arr) + Math.abs(arr[i] - arr[i+2]);

        return Math.min(iJump, jJump);
    }
}
