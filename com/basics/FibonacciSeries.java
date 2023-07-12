package com.basics;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int a = 0, b = 1, c = 0;

        System.out.println();
        System.out.print(0 + " ");
        for(int i = 1; i <= n; i++) {
            c = a + b;

            System.out.print(c + " ");
            a = b;
            b = c;
        }

    }
}
