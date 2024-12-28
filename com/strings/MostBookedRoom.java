package com.strings;

import java.util.HashMap;
import java.util.Map;

public class MostBookedRoom {
    public static void main(String[] args) {
        String[] arr = {"+1A", "+3E", "-1A", "+4F", "+1A", "-3E"};

        System.out.println(solver(arr));
    }

    private static String solver(String[] arr) {
        Map<String, Integer> mp = new HashMap<>();
        int iMax = Integer.MIN_VALUE;
        String ans = null;
        for (String curr : arr) {
            String room = curr.substring(1);
            if (mp.containsKey(room)) {
                mp.remove(room, mp.get(room) + 1);
            } else {
                mp.put(room, 1);
            }
        }

        for(Map.Entry<String, Integer> m : mp.entrySet()) {
            if(m.getValue() > iMax) {
                ans = m.getKey();
                iMax = m.getValue();
            }
        }

        return ans;
    }
}
