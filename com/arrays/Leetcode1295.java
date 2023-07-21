package com.arrays;

public class Leetcode1295 {
    public static void main(String[] args) {
        int[] arr = {12, 34, 567, 1, 78};
        System.out.println(findNumbers(arr));
    }

    public static int findNumbers(int[] nums) {
        int iCnt = 0;
        for(int ele : nums) {
            if(countDigits(ele) % 2 == 0)
                iCnt++;
        }
        return iCnt;
    }

    private static int countDigits(int num) {
        int iCnt = 0;

        while(num > 0) {
            num /= 10;
            iCnt++;
        }
        return iCnt;
    }

}
