package com.leetcode_daily_challenge;

public class MakeTwoArraysEqualByReversingSubArrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] countMap = new int[1001];
        int n = target.length, maxVal = 0;
        for (int i = 0; i < n; i++) {
            countMap[arr[i]]++;
            countMap[target[i]]--;
            maxVal = Math.max(maxVal, arr[i]);
        }

        for (int i = 0; i <= maxVal; i++) {
            if (countMap[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean canBeEqualApproachTwo(int[] target, int[] arr) {
        int[] countMap = new int[1001];
        for (int num : arr) {
            countMap[num]++;
        }

        for (int num : target) {
            countMap[num]--;
            if (countMap[num] < 0) {
                return false;
            }
        }
        return true;
    }
}
