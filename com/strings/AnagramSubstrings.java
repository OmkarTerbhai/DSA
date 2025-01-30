package com.strings;

public class AnagramSubstrings {
    public static void main(String[] args) {

    }

    private static int solver(String s) {
        int n = s.length();
        int iMax = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrome(s.substring(i, j+1))) {
                    iMax = Math.max(iMax, s.substring(i, j+1).length());
                }
            }
        }
        return iMax;
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;j--;
        }
        return true;
    }
}
