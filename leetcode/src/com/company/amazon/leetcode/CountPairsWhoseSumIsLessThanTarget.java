package com.company.amazon.leetcode;

import java.util.Arrays;
import java.util.List;

public class CountPairsWhoseSumIsLessThanTarget {
    private int countPairs(List<Integer> nums, int target) {
        int pairsCount = 0, size = nums.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    pairsCount++;
                }
            }
        }
        return pairsCount;
    }

    public static void main(String[] args) {
        CountPairsWhoseSumIsLessThanTarget countPairsWhoseSumIsLessThanTarget = new CountPairsWhoseSumIsLessThanTarget();
        countPairsWhoseSumIsLessThanTarget.countPairs(Arrays.asList(-1, 1, 2, 3, 1), 2);
    }
}
