package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(arr));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int low = i+1, high = nums.length - 1;
            while(low < high) {


                int iSum = nums[low] + nums[high] + nums[i];
                if(iSum == 0) {
                    ansList.add(Arrays.asList(nums[low], nums[high], nums[i]));
                    low++;high--;
                    while(low < high && nums[low] == nums[low-1]) low++;
                    while(low < high && nums[high] == nums[high+1]) high--;

                }
                else if(iSum < 0) {
                    low++;
                }
                else {
                    high--;
                }
            }
        }

        return ansList;
    }
}
