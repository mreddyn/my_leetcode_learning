package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

public class NumberOfDistinctAverages {
    public int distinctAverages(int[] nums) {
        int n = nums.length;
        var seen = new HashSet<Double>();
        Arrays.sort(nums);
        int left = 0, right = n - 1;
        while (left < right) {
            double avg = (nums[left++] + nums[right--]) / 2.0;
            seen.add(avg);
        }
        System.out.println(seen);
        return seen.size();
    }

    public int distinctAveragesApproachTwo(int[] nums) {
        int n = nums.length, distinctCount = 0;
        var map = new int[201];
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int sum = nums[i] + nums[n - 1 - i];
            if (map[sum] > 0) {
                continue;
            }
            distinctCount += ++map[sum];
        }

        return distinctCount;
    }

    public static void main(String[] args) {
        NumberOfDistinctAverages nAverages = new NumberOfDistinctAverages();
        System.out.println(nAverages.distinctAverages(new int[] { 9, 5, 7, 8, 7, 9, 8, 2, 0, 7 }));
    }
}
