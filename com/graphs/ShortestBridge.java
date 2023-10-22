package com.graphs;
import javafx.util.Pair;


import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static int shortestBridge(int[][] grid) {
        int shortest = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[][] vis = new int[grid.length][grid[0].length];

        //Populate visited matrix
        for(int i = 0; i < vis.length; i++) {
            for(int j = 0; j < vis[0].length; j++) {
                vis[i][j] = grid[i][j];
            }
        }

        //Find first island of 1s
        for(int i = 0; i < vis.length; i++) {
            for(int j = 0; j < vis[0].length; j++) {
                if(vis[i][j] == 1) {
                    dfs(vis, i, j, queue);
                    //Now BFS Over the DFSed queue i.e.the first island

                    while(!queue.isEmpty()) {
                        int qs = queue.size();
                        while(qs-- > 0) {
                            Pair<Integer, Integer> curr = queue.poll();
                            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                            if (curr.getKey() >= 0 && curr.getValue() >= 0 && curr.getKey() <= grid.length - 1 && curr.getValue() <= grid[0].length - 1) {


                                for (int[] p : dirs) {
                                    int newX = curr.getKey() + p[0];
                                    int newY = curr.getValue() + p[1];
                                    if (newX >= 0 && newY >= 0 && newX <= grid.length - 1 && newY <= grid[0].length - 1) {

                                        if (vis[newX][newY] == 1) {
                                            return shortest;
                                        }
                                        if (vis[newX][newY] == 0) {
                                            queue.add(new Pair<Integer, Integer>(newX, newY));
                                        }
                                    }

                                }
                            }
                        }
                        shortest++;
                    }
                }

            }
        }



        return shortest;

    }

    public static void dfs(int[][] grid, int i, int j, Queue<Pair<Integer, Integer>> queue) {
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1) {
            return;
        }
        if(grid[i][j] == -1) {
            return;
        }
        //Mark Visited
        grid[i][j] = -1;
        queue.add(new Pair<Integer, Integer>(i,j));
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int[] p : dirs) {
            int newX = i + p[0];
            int newY = j + p[1];
            if(newX >= 0 && newY >= 0 && newX <= grid.length-1 && newY <= grid[0].length-1) {
                if (grid[newX][newY] == 1) {
                    dfs(grid, newX, newY, queue);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};

        System.out.println(shortestBridge(grid));
    }
}
