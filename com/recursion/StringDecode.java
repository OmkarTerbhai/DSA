package com.recursion;

public class StringDecode {
    public static void main(String[] args) {
        System.out.println(decode("123", 0, ""));
    }

    static int decode(String s, int i, String op) {
        if(i == s.length()) {
            System.out.println(" " + op);
            return 1;
        }
        if(s.charAt(0) == '0') {
            return 0;
        }

        char digit = (char) (Integer.parseInt(String.valueOf(s.charAt(i))) + '@');
        int leftCnt = decode(s, i+1, op + digit);//Pick 1
        int rightCnt = 0;
        if(i+2 <= s.length()) {
            char digit2 = (char) (Integer.parseInt(s.substring(i, i+2)) + '@');
            rightCnt = decode(s, i+2, op+ digit2);//Pick 2
        }
        return leftCnt + rightCnt;

    }

}
