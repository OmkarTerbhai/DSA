package com.graphs;

import java.util.*;

public class GraphImpl {
    private  List<LinkedList<Integer>> graph = null;

    public GraphImpl(int noOfVertices) {
        graph = new ArrayList<>(noOfVertices);
        for(int i = 0; i < noOfVertices; i++) {
            graph.add(i, new LinkedList<>());
        }
    }

    private  void display() {
        for(int i = 0; i < graph.size(); i++) {
            System.out.print(i + "->");
            for(int ele : graph.get(i)) {
                System.out.print(ele + ", ");
            }
            System.out.println();
        }
    }

    private void dfs(int src) {
        List<Integer> li = new ArrayList<>();
        dfsHelper(src, li);
    }

    private void dfsHelper(int src, List<Integer> li) {
        System.out.println(src);
        li.add(src);
        for(int neighbour : graph.get(src)) {
            if(!li.contains(neighbour)) {

                dfsHelper(neighbour, li);
            }
        }
    }

    private void bfs(int src) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> li = new ArrayList<>();

        queue.add(src);
        li.add(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);

            for(int neighbour : graph.get(node)) {
                if(!li.contains(neighbour)) {
                    queue.add(neighbour);
                    li.add(neighbour);
                }
            }
        }

    }

    private int traverseConnected() {
        List<Integer> li = new ArrayList<>();
        int connectedComponents = 0;
        for(int i = 0; i < graph.size(); i++) {
            if(!li.contains(i)) {
                dfsHelper(i, li);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }

    public static void main(String[] args) {
        GraphImpl g = new GraphImpl(5);
        g.graph.get(1).add(0);
        g.graph.get(2).add(1);
        g.graph.get(3).add(4);
//        g.dfs(0);
        //g.bfs(0);
        System.out.println("No of connected components: "+ g.traverseConnected());
    }
}
