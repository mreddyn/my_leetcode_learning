package com.company.amazon.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        /*
         * create a indices array and sort it based on nums.
         * Iterate through the nums array and find the smallest index to calculate
         * maxWidth
         */
        int maxRampWidth = 0, n = nums.length;
        var indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // sort the indices array based on nums
        Arrays.sort(indices, (i, j) -> (nums[i] != nums[j]) ? nums[i] - nums[j] : i - j);

        int minIndex = n;
        for (int index : indices) {
            maxRampWidth = Math.max(maxRampWidth, index - minIndex);
            minIndex = Math.min(minIndex, index);
        }
        return maxRampWidth;
    }

    public int maxWidthRampApproachTwo(int[] nums) {
        /*
         * We will construct a right max array which will contain the
         * max elements we encountered from the end.
         * After that we will maintain a two pointers left for nums, and right for
         * rightMax.
         * Whenever nums[left] <= rightMax[right] we will calculate maxWidth
         */
        int n = nums.length, maxRampWidth = 0;
        var rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int left = 0, right = 0;
        while (right < n) {
            // whenever nums[left] > rightMax[right], we increment the left pointer
            while (left < right && nums[left] > rightMax[right]) {
                left++;
            }

            maxRampWidth = Math.max(maxRampWidth, right - left);
            right++;
        }

        return maxRampWidth;
    }

    public int maxWidthRampApproachThree(int[] nums) {
        int maxWidth = 0, n = nums.length;

        // a monotonic stack to maintain the elements in increasing order of values
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        // now iterate through the nums array from back
        // check if the current element is greater than the element on top of stack
        // if so then calculate width and pop it
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                maxWidth = Math.max(maxWidth, i - stack.peek());
                stack.pop();
            }
        }

        return maxWidth;
    }
}
