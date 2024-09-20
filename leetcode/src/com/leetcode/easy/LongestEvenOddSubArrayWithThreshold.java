package com.leetcode.easy;

public class LongestEvenOddSubArrayWithThreshold {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        /*
         * We need to find a subarray which has elements in the order even, odd, even,
         * odd and
         * each element in that sub array must be less than or equal to threshold.
         * The subarray should always start with even, fins such subarray of maximum
         * size.
         * We will maintain variable evenOdd=0, which will be flipped every time we
         * encounter the
         * element we match for. When the element does not match reset the size to zero
         * and set evenOdd to zero if its odd number else one and count current element.
         * 
         */
        int alternatingArrayMaxSize = 0, n = nums.length;
        int evenOdd = 0, alternatingArrayCurSize = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= threshold) {
                if (nums[i] % 2 == evenOdd) {
                    alternatingArrayCurSize++;
                    evenOdd = (evenOdd == 1) ? 0 : 1;
                } else if (nums[i] % 2 == 0) {
                    alternatingArrayCurSize = 1;
                    evenOdd = 1;
                } else {
                    alternatingArrayCurSize = 0;
                    evenOdd = 0;
                }
            } else {
                alternatingArrayCurSize = 0;
                evenOdd = 0;
            }

            alternatingArrayMaxSize = Math.max(alternatingArrayMaxSize, alternatingArrayCurSize);
        }

        return alternatingArrayMaxSize;
    }
}
