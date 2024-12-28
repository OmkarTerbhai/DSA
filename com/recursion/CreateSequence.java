package com.recursion;

import java.util.ArrayList;

public class CreateSequence {
    public static void main(String[] args) {
        createSequence(100);
    }

    public static ArrayList<Long> createSequence(long n){
        ArrayList<Long> ans = new ArrayList<>();
        helper(0, new int[]{2,5}, n, ans);
        System.out.println(ans);
        return ans;
    }

    private static void helper(long num, int[] arr, long limit, ArrayList<Long> ans) {
        if(num > limit) {
            return;
        }
        else {
            if(num != 0)
                ans.add(num);
        }

        for(int ele : arr) {
            long newNum = num * 10 + ele;
            helper(newNum, arr, limit, ans);
        }
        return;
    }
}
