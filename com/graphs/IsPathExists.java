package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IsPathExists {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<LinkedList<Integer>> graph = prepareGraph(n, edges);

        return dfs(source, destination, graph);

    }

    private static List<LinkedList<Integer>> prepareGraph(int n, int[][] edges) {
        List<LinkedList<Integer>> ret = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            ret.add(i, new LinkedList<>());
        }

        for(int[] edge : edges) {
            ret.get(edge[0]).add(edge[1]);
        }
        return ret;
    }

    private static boolean dfs(int src, int dest, List<LinkedList<Integer>> graph) {
        List<Integer> li = new ArrayList<>();
        return dfsHelper(src, li, dest, graph);
    }

    private static boolean dfsHelper(int src, List<Integer> li, int dest, List<LinkedList<Integer>> graph) {

        if(src == dest)
        {
            return true;
        }
        if(li.contains(src)) {
            return false;
        }
        li.add(src);
        for(int neighbour : graph.get(src)) {
            if(!li.contains(neighbour)) {

                if(dfsHelper(neighbour, li, dest, graph)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};

        System.out.println(validPath(10, graph, 7, 5));
    }
}
