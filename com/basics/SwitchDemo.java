package com.basics;

import java.util.Scanner;

public class SwitchDemo {
    /*
     * Switch case gives better alternate to  if-else ladder.
     */
    public static void main(String[] args) {
        int day;
        Scanner in = new Scanner(System.in);
        day = in.nextInt();

        switch (day) {
            case 1 -> System.out.println("Today is Monday");
            case 2 -> System.out.println("Today is Tuesday");
            case 3 -> System.out.println("Today is Wednesday");
            case 4 -> System.out.println("Today is Thursday");
            case 5 -> System.out.println("Today is Friday");
            case 6 -> System.out.println("Today is Saturday");
            case 7 -> System.out.println("Today is Sunday");
        }
    }
}
