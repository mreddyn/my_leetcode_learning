package com.company.servicenow;

public class SubArraysProductLessThanK {
    private int numSubArrayProductLessThanK(int[] nums, int k) {
        int subArraysCount = 0;
        if (k == 0) {
            return subArraysCount;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product = product * nums[j];
                if (product < k) {
                    subArraysCount++;
                }
            }
        }
        return subArraysCount;
    }

    private int numSubArrayProductLessThanKSlidingWindowApproach(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int n, subArraysCount, winStart, winEnd, product;
        n = nums.length;
        subArraysCount = 0;
        winStart = 0;
        product = 1;
        for (winEnd = 0; winEnd < n; winEnd++) {
            product = product * nums[winEnd];
            while (product >= k) {
                product = product / nums[winStart];
                winStart++;
            }
            subArraysCount = subArraysCount + winEnd - winStart + 1;
        }

        return subArraysCount;
    }

    public static void main(String[] args) {
        SubArraysProductLessThanK subArraysProductLessThanK = new SubArraysProductLessThanK();
        int[] nums = { 10, 5, 2, 6 };
        int k = 100;
        System.out.println(subArraysProductLessThanK.numSubArrayProductLessThanK(nums, k));
        System.out.println(subArraysProductLessThanK.numSubArrayProductLessThanKSlidingWindowApproach(nums, k));
    }
}
