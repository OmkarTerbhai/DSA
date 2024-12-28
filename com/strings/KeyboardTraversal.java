package com.strings;

import java.util.HashMap;
import java.util.Map;

public class KeyboardTraversal {
    public static void main(String[] args) {
        String keys = "abcdefghijklmnopqrstuvwxy";
        String word = "cba";

        System.out.println(solver(keys, word));
    }
    private static int solver(String keys, String word) {
        Map<Character, Integer> mp = new HashMap<>();
        int iAns = 0;
        for(int i = 0; i < keys.length(); i++) {
            mp.put(keys.charAt(i), i);
        }

        int currDiff = 0;

        for(int i = 0; i < word.length(); i++) {
            int newPos = mp.get(word.charAt(i));
            iAns += Math.abs(newPos - currDiff);
            currDiff = newPos;
        }
        return iAns;
    }
}
