package com.leetcode_daily_challenge;

public class NumberOfGoodPairs {
    private int numIdenticalPairs(int[] nums) {
        if (nums.length == 1)
            return 0;
        int frequencyMap[] = new int[101];
        for (int num : nums) {
            frequencyMap[num]++;
        }
        int goodPairsCount = 0;
        for (int frequency : frequencyMap) {
            if (frequency > 1) {
                goodPairsCount += (frequency * (frequency - 1)) / 2;
            }
        }
        return goodPairsCount;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1, 1, 3 };
        NumberOfGoodPairs ngp = new NumberOfGoodPairs();
        System.out.println(ngp.numIdenticalPairs(nums));
    }
}
