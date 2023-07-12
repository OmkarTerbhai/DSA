package com.basics;

import java.util.Scanner;

public class StringBuilderDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i < sb.length(); i++) {

            if(i % 2 == 0) {
                char ch = sb.charAt(i);
                ch++;
                sb.setCharAt(i, ch);
            }
            else {
                char ch = sb.charAt(i);
                ch--;
                sb.setCharAt(i, ch);
            }
        }

        System.out.println(sb);
    }
}
