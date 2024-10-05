package com.leetcode.medium;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        /*
         * If there is no zero in the array, then the subarray with the maximum product
         * must start
         * with the first element or end with last element. And therefore the maximum
         * product will be either prefix product or suffix product.
         * 
         * If there is zero in the array then we can split the array into smaller ones.
         * suppose if prefix is zero, we start over.
         */
        int n = nums.length, maximumProduct = nums[0], prefixProduct = 0, suffixProduct = 0;
        for (int i = 0; i < n; i++) {
            if (prefixProduct == 0) {
                prefixProduct = 1 * nums[i];
            } else {
                prefixProduct *= nums[i];
            }

            if (suffixProduct == 0) {
                suffixProduct = 1 * nums[n - 1 - i];
            } else {
                suffixProduct *= nums[n - 1 - i];
            }

            maximumProduct = Math.max(maximumProduct, Math.max(prefixProduct, suffixProduct));
        }

        return maximumProduct;
    }
}
