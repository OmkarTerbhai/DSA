package com.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EliminateRacers {
    public static void main(String[] args) {
        String[][] strings = {{
                "Alex 100", "Bob 144", "Mathew 155"},
                {"Mathew 134", "Bob 144", "Alex 134"},
                {"Alex 100", "Bob 144", "Mathew 155"}
        };

        System.out.println(solver(strings));
    }

    private static List<String> solver(String[][] results) {

        List<String> li = new ArrayList<>();
        Set<String> st = new HashSet<>();

        for(int i = 0; i < results.length; i++) {
            int iMax = Integer.MIN_VALUE;
            String el = "";
            for(int j = 0; j < results[i].length; j++) {
                String[] sp = results[i][j].split(" ");
                String name = sp[0];
                int time = Integer.parseInt(sp[1]);

                if(!st.contains(name)) {
                    if(iMax < time) {
                        iMax = time;
                        el = name;
                    }
                }
            }
            st.add(el);
            li.add(el);
        }
        return li;
    }
}
