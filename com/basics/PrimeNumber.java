package com.basics;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = 2;
        for(i = 2; i*i <= n; i++) {
            if(n % i == 0)
                break;
        }
        if(i*i > n)
            System.out.println("Number is Prime");
        else
            System.out.println("Number is not prime");
    }
}
