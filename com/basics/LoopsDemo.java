package com.basics;

import java.util.Scanner;

public class LoopsDemo {
    public static void main(String[] args) {
        int a;
        Scanner in = new Scanner(System.in);

        a = in.nextInt();

        for(int i = 1; i <= a; i++) {
            System.out.println(i);
        }
    }
}
