package com.recursion;

public class PatternsRecursion {
    public static void main(String[] args) {
        pattern1(4, 1, 4);
    }
    static void pattern1(int n, int col, int totalCols) {
        if (n == 0) return; //End of rows

        if(col <= totalCols - n + 1) {
            System.out.print(" * ");
            pattern1(n, col + 1, totalCols);
        }
        else {
            System.out.println();
            pattern1(n-1, 1, totalCols);
        }

    }


}
