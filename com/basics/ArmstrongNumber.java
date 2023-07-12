package com.basics;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(isArmstrong(n));
    }

    /*
     * Such a number which is equal to sum of digits raised to the power of
     * number of digits in that exam.
     */
    private static boolean isArmstrong(int n) {
        int tempSum = n;
        int digitCnt = countDigits(n);
        int sum = 0;
        while(n > 0) {
            int remainder = n % 10;
            sum += Math.pow(remainder, digitCnt);
            n /= 10;
        }
        return sum == tempSum;
    }

    private static int countDigits(int n) {
        int iCnt = 0;

        while(n > 0) {
            iCnt++;
            n /= 10;
        }
        return iCnt;
    }
}
