package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();

        li.add(21);
        li.add(31);
        li.add(41);
        li.add(51);
        System.out.println(li);
        li.remove(2);

        System.out.println(li);
    }
}
