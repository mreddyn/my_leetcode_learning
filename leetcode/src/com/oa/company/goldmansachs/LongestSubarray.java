package com.oa.company.goldmansachs;

public class LongestSubarray {
    public int maxLength(int[] nums, int k) {
        /*
         * A subarray of array a is defined as a contiguous block of a's elements having
         * a length that is less than or equal to the length of the array. For example,
         * the subarrays of array a = [1, 2, 3] are [1], [2], [3], [1, 2], [2, 3], and
         * [1, 2, 3]. Given an integer, k = 3, the subarrays having elements that sum to
         * a number ≤ k are [1], [2], and [1, 2]. The longest of these subarrays is [1,
         * 2], which has a length of 2. Given an array, a, determine its longest
         * subarray that sums to less than or equal to a given value k.
         */
        int n = nums.length;
        int sum = 0;
        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            sum += nums[end];
            while (sum > k) {
                sum -= nums[start];
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarray obj = new LongestSubarray();
        int[] nums = { 1, 2, 3 };
        int k = 4;
        System.out.println(obj.maxLength(nums, k)); // 2
    }
}
