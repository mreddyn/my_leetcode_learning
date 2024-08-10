package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementTwo {
    private List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityElementsList = new ArrayList<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        final int majorityElementFrequency = nums.length / 3;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) > majorityElementFrequency) {
                majorityElementsList.add(key);
            }
        }
        return majorityElementsList;
    }

    public static void main(String[] args) {
        MajorityElementTwo majorityElementTwo = new MajorityElementTwo();
        int[] nums = { 1, 2 };
        System.out.println(majorityElementTwo.majorityElement(nums));
    }
}
