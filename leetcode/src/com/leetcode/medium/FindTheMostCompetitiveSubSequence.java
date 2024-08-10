package com.leetcode.medium;

import java.util.ArrayDeque;

public class FindTheMostCompetitiveSubSequence {
    public int[] mostCompetitive(int[] nums, int k) {
        /*
         * Maintain a monotonic increasing stack to keep track of indices.
         * Iterate through the nums array and whenever we encounter current element
         * smaller than
         * the top element in stack and remaining elements (n-i+stack.size) > k we pop
         * the top element.
         * 
         * If stack size is less than k we add the current element index to the stack.
         * 
         * Finally return the elements from the stack
         */
        int[] result = new int[k];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int curElement = nums[i];

            while (!stack.isEmpty() && curElement < nums[stack.peek()] && (nums.length - i + stack.size()) > k) {
                stack.pop();
            }

            if (stack.size() < k) {
                stack.push(i);
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            result[i] = nums[stack.pop()];
        }
        return result;
    }
}
