package com.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerGarden {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1,3,2));

        System.out.println(ninjaGarden(arr, 3, 1));
    }
    public static int ninjaGarden (ArrayList<Integer> flowers, int n, int k) {
        boolean[] garden = new boolean[n+1];
        Arrays.fill(garden, false);
        for(int i = 0; i < flowers.size(); i++) {
            garden[i] = true;

            if(garden[i] == garden[n-k-1] || garden[i] == garden[n+k+1]) {
                return i+1;
            }
        }
        return -1;
    }
}
