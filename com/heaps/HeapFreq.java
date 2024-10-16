package com.heaps;

import java.util.*;

class MyNode {
    int iNo;
    int freq;

    MyNode(int iNo, int freq) {
        this.iNo = iNo;
        this.freq = freq;
    }
}
public class HeapFreq {

    public static void main(String[] args) {
        HeapFreq hf = new HeapFreq();
        System.out.println(Arrays.toString(hf.topKFrequent(new int[]{1, 2}, 2)));
    }

        public int[] topKFrequent(int[] nums, int k) {
            int[] freqArray = new int[nums.length];

            Map<Integer, Integer> mp = new HashMap<>();
            List<Integer> li = new ArrayList<>();
            Arrays.fill(freqArray, -1);
            for (int ele : nums) {
                if (mp.containsKey(ele)) {
                    mp.replace(ele, mp.get(ele) + 1);
                } else {
                    mp.put(ele, 1);
                }
            }

            for (Map.Entry<Integer, Integer> ele : mp.entrySet()) {
                freqArray[ele.getValue()-1] = ele.getKey();
            }
            for(int i = freqArray.length - 1; i >= 0; i--) {
                if(freqArray[i] != -1) {
                    li.add(freqArray[i]);

                    if(li.size() > k) {
                        li.remove(li.size()-1);
                        break;
                    }

                }

            }
            return li.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
}
