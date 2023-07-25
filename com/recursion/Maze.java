package com.recursion;

public class Maze {
    public static void main(String[] args) {
        maze(0,0,3,3,"");
    }

    static void maze(int i, int j, int m, int n, String s) {
        if(i == m-1 && j == n-1) {
            System.out.println(s);
        }
        if(i >= m || j >= n) {
            return;
        }

        maze(i+1, j, m, n, s+'D');
        maze(i, j+1, m,n,s+'R');
    }
}
