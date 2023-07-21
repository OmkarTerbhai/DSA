package com.arrays;

import java.util.Scanner;

public class TwoDArrays {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        Scanner in = new Scanner(System.in);

        for(int i = 0; i <= arr.length-1; i++) {
            for(int j = 0; j <= arr[i].length-1; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        for(int i = 0; i <= arr.length-1; i++) {
            for(int j = 0; j <= arr[i].length-1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
