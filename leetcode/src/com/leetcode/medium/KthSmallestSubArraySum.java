package com.leetcode.medium;

import java.util.Arrays;

public class KthSmallestSubArraySum {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int left = 1, right = Arrays.stream(nums).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countLessEqual(nums, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int countLessEqual(int[] nums, int target) {
        // returns the count where the number of subarrays sum which is less than or
        // equal to target
        int n = nums.length, sum = 0, count = 0;
        for (int end = 0, start = 0; end < n; end++) {
            sum += nums[end];
            while (sum > target) {
                sum -= nums[start];
                start++;
            }
            count += end - start + 1;
        }

        return count;
    }
}
