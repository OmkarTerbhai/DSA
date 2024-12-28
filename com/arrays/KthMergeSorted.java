package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthMergeSorted {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(List.of(1,4,7,10));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(2,5,6));

        System.out.println(findKthElement(arr1, arr2, 4));
    }
    public static int findKthElement(ArrayList<Integer> arr1,
                                     ArrayList<Integer> arr2, int k) {

        int m = arr1.size();
        int n = arr2.size();

        List<Integer> li = new ArrayList<>(arr1);
        li.addAll(arr2);
        Collections.sort(li);
        for(int ele : li) {
            k--;
            if(k == 0)
                return ele;
        }
        return -1;
    }
}
