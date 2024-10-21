package com.company.rubrik.hard;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int numOfWindow = n - k + 1;
        var result = new int[numOfWindow];
        for (int start = 0; start < numOfWindow; start++) {
            int end = start + k - 1;
            int maxVal = nums[start];
            for (int i = start + 1; i <= end; i++) {
                maxVal = Math.max(maxVal, nums[i]);
            }
            result[start] = maxVal;
        }

        return result;
    }

    public int[] maxSlidingWindowApproachTwo(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        var pQueue = new PriorityQueue<Integer>((a, b) -> (nums[b] - nums[a]));
        int numOfWindow = n - k + 1;
        int[] res = new int[numOfWindow];
        for (int i = 0; i < n; i++) {
            int start = i - k;
            if (start >= 0) {
                pQueue.remove(start);
            }

            pQueue.offer(i);
            if (pQueue.size() == k) {
                res[i - k + 1] = nums[pQueue.peek()];
            }
        }

        return res;
    }

    public int[] maxSlidingWindowApproachThree(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        var win = new ArrayDeque<Integer>();
        int numOfWindow = n - k + 1;
        int[] res = new int[numOfWindow];

        for (int i = 0; i < n; i++) {
            // remove indices that are out of bound from front of queue
            while (win.size() > 0 && win.peekFirst() <= i - k) {
                win.pollFirst();
            }

            // remove elements which are less than the current element from end
            // as they will not contribute towards maximum
            while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }

            // add current element
            win.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[win.peekFirst()];
            }
        }

        return res;
    }
}
