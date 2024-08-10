package com.company.amazon.leetcode.medium;

public class HouseRobberFour {
    public int minCapability(int[] nums, int k) {
        /*
         * Binary search the minimum capability of the robber
         * to steal at least k houses.
         * 
         * Given 1 <= A[i] <= 1e9,
         * we can initial the binary search range as
         * left = 1 and right = 1e9.
         * we can also set left = min(A) and right = max(A).
         * 
         * Assume the capability is mid,
         * we iterate the houses A,
         * and greedily take the houses as many as possible,
         * if mid > A[i] and we didn't take A[i-1].
         * 
         * Then we check if we have take k houses,
         * If take >= k,
         * we have big enough capability,
         * right = mid.
         * If take < k,
         * we don't have big enough capability,
         * left = mid + 1.
         * 
         * Finally we return the binary search result.
         */
        int n = nums.length, minElement = Integer.MAX_VALUE, maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            minElement = Math.min(minElement, nums[i]);
            maxElement = Math.max(maxElement, nums[i]);
        }
        int left = minElement, right = maxElement;
        while (left < right) {
            int mid = left + (right - left) / 2, take = 0;
            for (int i = 0; i < n; i++) {
                if (mid <= nums[i]) {
                    take++;
                    i++;
                }
            }
            if (take >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
