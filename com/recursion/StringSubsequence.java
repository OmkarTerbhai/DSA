package com.recursion;

public class StringSubsequence {
    public static void main(String[] args) {
        printSubsequences("abc", 0, "");
    }

    static void printSubsequences(String str, int idx, String output) {
        if(idx >= str.length()) {
            System.out.println(output);
            output = "";
            return;
        }

        printSubsequences(str, idx+1, output + str.charAt(idx));

        printSubsequences(str, idx+1, output);
    }
}
