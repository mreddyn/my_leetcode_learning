package com.leetcode;

import java.util.Iterator;
import java.util.PriorityQueue;

public class MaximumProductAfterKIncrements {
    public int maximumProduct(int[] nums, int k) {
        int mod = 1000000007, n = nums.length;
        long maxProduct = 1;
        /*
         * Build a min heap of nums array and loop through the k, increment the element
         * which is polled from heap and push it to heap. Do this k times
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < n; i++) {
            minHeap.add(nums[i]);
        }

        while (k-- > 0) {
            int num = minHeap.poll();
            num++;
            minHeap.add(num);
        }

        // Now iterate through the minHeap and get the product
        Iterator<Integer> iterator = minHeap.iterator();
        while (iterator.hasNext()) {
            maxProduct = maxProduct * iterator.next();
            maxProduct = maxProduct % mod;
        }

        return (int) (maxProduct % mod);
    }

    public static void main(String[] args) {
        MaximumProductAfterKIncrements mAfterKIncrements = new MaximumProductAfterKIncrements();
        mAfterKIncrements.maximumProduct(null, 0);
    }
}
