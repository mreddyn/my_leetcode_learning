package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ArrayNesting {
    Set<Integer> seen;

    private int arrayNesting(int[] nums) {
        int longestLength = 0, n = nums.length, curSetLength = 0;
        if (isArrayElementPresentAtSameIndex(nums)) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            seen = new HashSet<>();
            dfs(nums, i);
            curSetLength = seen.size();
            longestLength = Math.max(longestLength, curSetLength);
        }

        return longestLength;
    }

    private void dfs(int[] nums, int index) {
        int ele = nums[index];
        if (seen.contains(ele)) {
            return;
        }
        seen.add(ele);
        dfs(nums, ele);
    }

    private boolean isArrayElementPresentAtSameIndex(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private int arrayNestingApproachTwo(int[] nums) {
        int longestLength = 0, n = nums.length, curLength = 0;
        for (int i = 0; i < n; i++) {
            curLength = 0;
            for (int k = i; nums[k] >= 0; curLength++) {
                int ele = nums[k];
                nums[k] = -1;
                k = ele;
            }
            longestLength = Math.max(longestLength, curLength);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        ArrayNesting arrayNesting = new ArrayNesting();
        System.out.println(arrayNesting.arrayNesting(new int[] { 0, 1, 2 }));
        System.out.println(arrayNesting.arrayNestingApproachTwo(new int[] { 5, 4, 0, 3, 1, 6, 2 }));
    }
}
