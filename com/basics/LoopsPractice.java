package com.basics;

public class LoopsPractice {
    public static void main(String[] args) {
        int i = 1, j = 1;
        while(i <= 4) {
            System.out.println("Outer Loop: "+i);
            while (j <= 3) {
                if (j == 2) {
                    j++;
                    continue;
                }
                System.out.println("Inner Loop: " + j);
                j++;
            }
            i++;
        }
    }
}
