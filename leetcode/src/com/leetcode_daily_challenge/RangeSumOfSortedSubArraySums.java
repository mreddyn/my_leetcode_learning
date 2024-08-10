package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSumOfSortedSubArraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1000000007, totalSubArrays = (n * (n + 1)) / 2;
        long rangeSum = 0;
        List<Integer> sums = new ArrayList<>(totalSubArrays);
        for (int i = 0; i < n; i++) {
            int subArraySum = 0;
            for (int j = i; j < n; j++) {
                subArraySum += nums[j];
                sums.add(subArraySum);
            }
        }

        Collections.sort(sums);
        for (int index = left - 1; index < right; index++) {
            rangeSum += sums.get(index);
        }
        return (int) (rangeSum % MOD);
    }
}
