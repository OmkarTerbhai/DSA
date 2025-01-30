package com.hashmaps;

public class MyHashMapDemo {
    public static void main(String[] args) {
        CustomHashMap<Integer, Integer> mp = new CustomHashMap<>();

        mp.insert(21, 23);
        mp.insert(23, 21);
        mp.insert(21, 14);

        System.out.println(mp);
    }
}
