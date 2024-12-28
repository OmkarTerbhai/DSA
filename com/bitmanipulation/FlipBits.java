package com.bitmanipulation;

public class FlipBits {
    public static void main(String[] args) {
        System.out.println(flipSomeBits(21, new int[]{4,2,1}, 3));
    }
    public static int flipSomeBits(int num, int[] arr, int n) {

        for(int ele : arr) {
            int res = 1 << (ele-1);

            num = num ^ res;
        }
        return num;
    }
}
