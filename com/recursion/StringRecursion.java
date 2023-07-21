package com.recursion;

public class StringRecursion {
    public static void main(String[] args) {
        System.out.println(removeX("Oxmxxxxkxaxrxxx", 0, ""));
    }

    static String removeX(String str, int idx, String output) {
        if(idx >= str.length()) {
            return output;
        }

        if(str.charAt(idx) == 'x') {
            return removeX(str, idx+1, output);
        }
        else {
            return removeX(str, idx+1, output + str.charAt(idx));
        }
    }
}
