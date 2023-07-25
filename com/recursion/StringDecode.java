package com.recursion;

public class StringDecode {
    public static void main(String[] args) {
        System.out.println(decode("123", 0, ""));
    }

    static int decode(String s, int i, String op) {
        if(i == s.length()) {
            //System.out.println(" " + op);
            return 1;
        }
        if(s.charAt(0) == '0') {
            return 0;
        }

        int leftCnt = decode(s, i+1, op+s.charAt(i));//Pick 1
        int rightCnt = 0;
        if(i+2 <= s.length()) {
            rightCnt = decode(s, i+2, op+s.charAt(i)+s.charAt(i+1));//Pick 2
        }
        return leftCnt + rightCnt;

    }

}
