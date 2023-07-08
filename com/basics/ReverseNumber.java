package com.basics;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int i = in.nextInt();
        int ans = 0;
        while(i > 0) {
            int r = i % 10;
            ans = (ans * 10) + r;
            i /= 10;
        }

        System.out.println("Reversed Number is: " + ans);
    }
}
