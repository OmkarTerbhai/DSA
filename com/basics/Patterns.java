package com.basics;

public class Patterns {
    public static void main(String[] args) {
        pattern7(7);
    }

    private static void pattern1(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void pattern2(int n) {
        int stars = 1;
        int spaces = n-1;
        for(int i = 1; i <= n; i++) {
            //Work towards current row
            for(int a = 1; a <= spaces; a++) {
                System.out.print(" ");
            }
            for(int b = 1; b <= stars; b++) {
                System.out.print("*");
            }
            System.out.println();
            //Prepare for the next row
            stars += 2;
            spaces--;
        }
    }

    private static void pattern3(int n) {
        int stars = 1;

        for(int i = 1; i <= n; i++) {
            //Work for current row
            for(int j = 1; j <= stars; j++) {
                System.out.print(" * ");
            }

            //Prepare for next row
            System.out.println();
            if(i <= n/2) {
                stars++;
            }
            else {
                stars--;
            }
        }
    }
    private static void pattern4(int n) {
        int nos = 1;
        n = (n * 2) - 1;
        for(int i = 1; i <= n; i++) {
            //Work for current row
            for(int j = 1; j <= nos; j++) {
                System.out.print(" " + j + " ");
            }

            //Prepare for next row
            System.out.println();
            if(i <= n/2) {
                nos++;
            }
            else {
                nos--;
            }
        }
    }

    private static void pattern5(int n) {
        int spaces = n/2;
        int stars = 1;

        for(int i = 1; i <= n; i++) {
            //Work for current row
            for(int a = 1; a <= spaces; a++) {
                System.out.print(" ");
            }
            for(int b = 1; b <= stars; b++) {
                System.out.print("*");
            }

            //Prepare for next row
            System.out.println();

            if(i <= n/2) {
                stars += 2;
                spaces--;
            }
            else {
                stars -= 2;
                spaces++;
            }
        }
    }

    private static void pattern6(int n) {
        int starsAtTop = (n*2) - 1;

        for(int i = 1; i <= starsAtTop; i++) {
            System.out.print("*");
        }
        System.out.println();

        int stars = n-1;
        int spaces = 1;

        for(int i = 2; i <= n; i++) {
            //Work current row
            for (int a = 1; a <= stars; a++) {
                System.out.print("*");
            }
            for (int b = 1; b <= spaces; b++) {
                System.out.print(" ");
            }
            for (int c = 1; c <= stars; c++) {
                System.out.print("*");
            }

            //Prepare for the next row
            System.out.println();
            stars--;
            spaces += 2;
        }
    }

    private static void pattern7(int n) {
        int stars = 1;
        int spaces = n-2;
        int st;
        for(int i = 1; i <= n; i++) {
            //Work for current row

            for (int a = 1; a <= stars; a++) {
                System.out.print("*");
            }
            for (int b = 1; b <= spaces; b++) {
                System.out.print(" ");
            }
            if(i == (n/2)+1)
                st = stars - 1;
            else
                st = stars;
            for (int c = 1; c <= st; c++) {
                System.out.print("*");
            }

            //Prepare for next row
            System.out.println();
            if(i <= n/2) {
                stars++;
                spaces -= 2;
            }
            else {
                stars--;
                spaces += 2;
            }
        }
    }
}
