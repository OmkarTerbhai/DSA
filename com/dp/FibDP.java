package com.dp;

import java.util.HashMap;
import java.util.Map;

public class FibDP {
    static Map<Integer, Integer> mp = new HashMap<>();
    public static int fib(int n) {
        if(n == 1 || n == 0) {
            return n;
        }
        if(mp.containsKey(n)) {
            return mp.get(n);
        }
        int ans = fib(n-1) + fib(n-2);
        mp.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fib(9));
    }
}
