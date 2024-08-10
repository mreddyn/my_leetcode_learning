package com.leetcode_daily_challenge;

public class CountElementsWithMaximumFrequency {
    private int maxFrequencyElements(int[] nums) {
        int[] frequencyMap = new int[101];
        int n = nums.length;
        int maxFrequency, totalFrequencies;
        for (int i = 0; i < n; i++) {
            frequencyMap[nums[i]]++;
        }
        maxFrequency = 0;
        for (int i = 0; i < 101; i++) {
            maxFrequency = Math.max(maxFrequency, frequencyMap[i]);
        }
        totalFrequencies = 0;
        for (int i = 0; i < 101; i++) {
            if (frequencyMap[i] == maxFrequency) {
                totalFrequencies += maxFrequency;
            }
        }
        return totalFrequencies;
    }

    public static void main(String[] args) {
        CountElementsWithMaximumFrequency countElementsWithMaximumFrequency = new CountElementsWithMaximumFrequency();
        System.out.println(countElementsWithMaximumFrequency.maxFrequencyElements(new int[] { 1, 2, 2, 3, 1, 4 }));
    }
}
