package com.company.servicenow;

import java.util.HashSet;

public class FindSubArraysWithEqualSum {
    private boolean findSubArrays(int[] nums) {
        int n;
        n = nums.length;
        HashSet<Integer> subArraySum = new HashSet<>();
        for (int i = 1; i < n; i++) {
            int sum = nums[i] + nums[i - 1];
            if (subArraySum.contains(sum)) {
                return true;
            }
            subArraySum.add(sum);
        }

        return false;
    }
    public static void main(String[] args) {
        FindSubArraysWithEqualSum findSubArraysWithEqualSum = new FindSubArraysWithEqualSum();
        System.out.println(findSubArraysWithEqualSum.findSubArrays(new int[]{4,2,4}));
    }
}
