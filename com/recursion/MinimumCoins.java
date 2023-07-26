package com.recursion;

public class MinimumCoins {
    public static void main(String[] args) {
        System.out.println(findMinimum(new int[] {7, 5, 1}, 9));
    }

    static int findMinimum(int[] coins, int amount) {
        if(amount == 0) return 1;

        if(amount < 0) return 0;

        int iMin = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int iRet = (findMinimum(coins, amount - coins[i]));
            if(iMin > iRet) iMin = iRet+1;

        }
        return iMin;
    }
}
