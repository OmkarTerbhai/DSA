package com.recursion;

public class TilingWays {
    public static void main(String[] args) {
        System.out.println(calculateWays(4));
    }

    static int calculateWays(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        return calculateWays(n-1) + calculateWays(n-2);
    }
}
