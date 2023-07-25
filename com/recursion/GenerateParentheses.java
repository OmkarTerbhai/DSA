package com.recursion;

public class GenerateParentheses {
    public static void main(String[] args) {
        generateParentheses(3, 3, "");
    }

    static void generateParentheses(int o, int c, String output) {
        if(o == 0 && c == 0) {
            System.out.println(output);
            return;
        }

        if(o != 0) {
            generateParentheses(o-1, c, output + "(");
        }
        if(c > o) {
            generateParentheses(o, c-1, output + ")");
        }

    }


}
