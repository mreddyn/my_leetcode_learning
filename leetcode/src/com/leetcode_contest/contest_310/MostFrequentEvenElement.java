package com.leetcode_contest.contest_310;

import java.util.HashMap;

public class MostFrequentEvenElement {
    private static int mostFrequent(int []nums){
        int n;
        n = nums.length;
        boolean even = false;
        for(int i=0;i<n;i++){
            if(nums[i] % 2 == 0){
                even = true;
                break;
            }
        }
        if(even){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i:nums){
                if(i%2 == 0){
                    map.put(i, map.getOrDefault(i, 0)+1);
                }
                
            }
            int maxFreqEvenElement, maxFreqEvenElementFrequency;
            maxFreqEvenElement = Integer.MAX_VALUE;
            maxFreqEvenElementFrequency = -1;
            System.out.println(map);
            for(int key: map.keySet()){
                int value = map.get(key);
                if(maxFreqEvenElementFrequency < value){
                    maxFreqEvenElementFrequency = value;
                    maxFreqEvenElement = key;

                }
                if(maxFreqEvenElementFrequency == value && maxFreqEvenElement > key){
                    maxFreqEvenElementFrequency = value;
                    maxFreqEvenElement = key;
                }
            }
            return maxFreqEvenElement;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(mostFrequent(new int[]{0,1,2,2,2,4,4,4,1,4,2}));
        System.out.println(mostFrequent(new int[]{4,4,4,9,2,4}));
        System.out.println(mostFrequent(new int[]{29,47,21,41,13,37,25,7}));
        System.out.println(mostFrequent(new int[]{8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290}));
    }
}
