package com.recursion;

public class NthPowerSum {
    public static void main(String[] args) {
        int iRet = countCombinations(100, 2, 1, "");
        System.out.println("Combinations possible: " + iRet);
    }

    static int countCombinations(double x, int n, int i, String op) {
        if(x == 0) {
            System.out.println(op);
            return 1;
        }
        if(i > Math.sqrt(x)) {
            return 0;
        }
        if(Math.pow(i, n) > x) {
            return 0;
        }

        return countCombinations(x - Math.pow(i, n), n, i + 1, op + " " + i) + countCombinations(x, n, i + 1, op);
    }
}
