package com.recursion;

public class LexicographicNumbers {
    public static void main(String[] args) {
        printLexicographic(0, 11);
    }

    static void printLexicographic(int i, int n) {
        if(i <= n) {
            if(i!=0) {
                System.out.print(" " + i);
            }
        }
        else {
            return;
        }

        for(int k = 0; k <= 9; k++) {
            if(i == 0 && k == 0) {
                continue;
            }
            printLexicographic(10 * i + k, n);
        }
    }
}
