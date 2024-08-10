package com.leetcode_daily_challenge;

public class MinimumSwapsToGroupAllOnesTogetherTwo {
    public int minSwaps(int[] nums) {
        /*
         * Count the ones in the nums array.
         * We need to maintain a window of size of k where k = number of ones.
         * The window should move from one end to other end. If the window goes out of
         * the bounds then
         * we need to maintain it by %n (size of nums array).
         */
        int minSwaps = 0, n = nums.length, totalOnes = 0;
        for (int i = 0; i < n; i++) {
            totalOnes += nums[i];
        }

        if (totalOnes == 0 || totalOnes == 1) {
            return 0;
        }

        int windowEnd = 0, windowStart = 0, maxOnesInWindow = 0, onesInWindow = nums[0];
        // Slide the window across the array
        for (windowStart = 0; windowStart < n; windowStart++) {

            // Adjust onesCount by removing the element that is sliding out of
            // the window
            if (windowStart != 0) {
                onesInWindow -= nums[windowStart - 1];
            }

            // Expand the window to the right until it reaches the desired size
            while ((windowEnd - windowStart + 1) < totalOnes) {
                windowEnd++;
                onesInWindow += nums[windowEnd % n];
            }

            // Update the max ones in window every time the window is sliding
            maxOnesInWindow = Math.max(maxOnesInWindow, onesInWindow);
        }
        minSwaps = totalOnes - maxOnesInWindow;
        return minSwaps;
    }
}
