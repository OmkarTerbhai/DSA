package com.recursion;

public class FriendsPairing {
    public static void main(String[] args) {
        System.out.println(waysToPair(4));
    }
    static int waysToPair(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return waysToPair(n-1) + waysToPair(n-2) * (n-1);
    }
}
