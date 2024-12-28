package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HouseSegment {
    public static void main(String[] args) {
        int[] houses = {1,2,3,7,8,10,11};
        int[] queries = {2,8,10};

        System.out.println(Arrays.toString(solver(houses, queries)));
    }
    private static int[] solver(int[] houses, int[] queries) {
        int[] iRes = new int[queries.length];
        List<Integer> li = new ArrayList<>();
        for(int ele : houses) {
            li.add(ele);
        }

        for(int i = 0; i < queries.length; i++) {
            int house = queries[i];
            for(int j = 0; j < li.size(); j++) {
                if(li.get(j) == house) {
                    li.remove(li.get(j));
                    break;
                }
            }
            Collections.sort(li);
            iRes[i] = getSegments(li);
        }
        return iRes;
    }

    private static int getSegments(List<Integer>  houses) {

        int segments = 0;

        for(int i = 0; i < houses.size()-1; i++) {
            if(houses.get(i) != houses.get(i+1) -1)
               segments++;
        }
        return segments+1;
    }
}
