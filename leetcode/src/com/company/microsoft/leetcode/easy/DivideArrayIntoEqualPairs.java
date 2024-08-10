package com.company.microsoft.leetcode.easy;

import java.util.HashSet;

public class DivideArrayIntoEqualPairs {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        HashSet<Integer> seen = new HashSet<>(n / 2);
        for (int num : nums) {
            if (seen.contains(num)) {
                seen.remove(num);
                continue;
            }
            seen.add(num);
        }
        return seen.size() == 0;
    }

    public boolean divideArrayApproachTwo(int[] nums) {
        int[] count = new int[501];
        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i < 501; i++) {
            if (count[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
