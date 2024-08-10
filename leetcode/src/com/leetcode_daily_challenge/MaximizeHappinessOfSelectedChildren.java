package com.leetcode_daily_challenge;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {
    private long maximumHappinessSum(int[] happiness, int k) {
        long maxHappinessSum = 0;
        int n = happiness.length, level = 0;
        Arrays.sort(happiness);
        for (int i = n - 1; i >= 0; i--) {
            int val = happiness[i] - level;
            if (val <= 0 || k <= 0) {
                break;
            }
            maxHappinessSum += val;
            level++;
            k--;
        }
        return maxHappinessSum;
    }

    public static void main(String[] args) {
        MaximizeHappinessOfSelectedChildren mChildren = new MaximizeHappinessOfSelectedChildren();
        System.out.println(mChildren.maximumHappinessSum(new int[] { 2, 3, 4, 5 }, 1));
    }
}
