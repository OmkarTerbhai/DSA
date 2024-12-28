package com.stacks;

import java.util.LinkedList;
import java.util.Queue;

class Triplet {
    int row;
    int col;
    int t;

    public Triplet(int r, int c, int t) {
        this.row = r;
        this.col = c;
        this.t = t;
    }
}

public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        Queue<Triplet> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int time = Integer.MAX_VALUE;
        int[][] vis = new int[n][m];
        int fresh = 0;
        int rotten = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    vis[i][j] = 2;
                    queue.add(new Triplet(i,j,0));
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
                else {
                    vis[i][j] = 0;
                }
            }
        }

        while(!queue.isEmpty()) {
            Triplet curr = queue.remove();
            int ri = curr.row;
            int ci = curr.col;
            int ti = curr.t;

            int[] drow = {-1, 0, 1, 0};
            int[] dcol = {0, 1, 0, -1};

            for(int i = 0; i < 4; i++) {
                int row = drow[i] + ri;
                int col = dcol[i] + ci;

                if(row >= 0 && col >= 0 && row < n && col < m
                        && grid[row][col] == 1 && vis[row][col] != 2) {
                    vis[row][col] = 2;
                    queue.add(new Triplet(row, col, ti + 1));
                    time = ti+1;
                    rotten++;
                }
            }
        }

        if(rotten == fresh) return time;
        return -1;
    }
}
