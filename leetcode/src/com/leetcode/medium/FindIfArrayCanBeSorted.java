package com.leetcode.medium;

import java.util.HashMap;

public class FindIfArrayCanBeSorted {
    public boolean canSortArray(int[] nums) {
        if (isTheArraySorted(nums)) {
            return true;
        }
        var setBitCountMap = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int num : nums) {
            int setBits = Integer.bitCount(num);
            setBitCountMap.put(num, setBits);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1] && setBitCountMap.get(nums[j]) == setBitCountMap.get(nums[j + 1])) {
                    // swap
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return isTheArraySorted(nums);
    }

    private boolean isTheArraySorted(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean canSortArrayApproachTwo(int[] nums) {
        int n = nums.length;
        int numsOfSetBits = Integer.bitCount(nums[0]);
        int minOfSegment = nums[0], maxOfSegment = nums[0];

        // Initialize max of the previous segment to the smallest possible integer
        int maxOfPrevSegment = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            if (Integer.bitCount(nums[i]) == numsOfSetBits) {
                // Element belongs to the same segment
                // Update min and max values of the segment
                minOfSegment = Math.min(minOfSegment, nums[i]);
                maxOfSegment = Math.max(maxOfSegment, nums[i]);
            } else {
                // Element belongs to a new segment
                // Check if the segments are arranged properly
                if (minOfSegment < maxOfPrevSegment) {
                    return false;
                }

                // update the previous segment max
                maxOfPrevSegment = maxOfSegment;

                // start a new segment with current value
                minOfSegment = nums[i];
                maxOfSegment = nums[i];
                numsOfSetBits = Integer.bitCount(nums[i]);
            }
        }

        if (minOfSegment < maxOfPrevSegment) {
            return false;
        }
        return true;
    }
}
