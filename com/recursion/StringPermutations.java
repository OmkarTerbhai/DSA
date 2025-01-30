package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        solver("GOD");
    }

    private static void solver(String str) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] mp = new boolean[str.length()];
        Arrays.fill(mp, false);
        helper(str, new ArrayList<>(), mp, ans);

        System.out.println(ans);
    }

    private static void helper(String str, List<String> temp, boolean[] mp, List<List<String>> ans) {
        if(temp.size() == str.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        int n = str.length();
        for(int i = 0; i < n; i++) {
            if(!mp[i]) {
                temp.add(str.substring(i, i+1));
                mp[i] = true;
                helper(str, temp, mp, ans);
                temp.remove(temp.size()-1);
                mp[i] = false;
            }
        }
    }
}
