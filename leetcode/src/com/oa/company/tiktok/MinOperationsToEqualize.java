package com.oa.company.tiktok;

import java.util.PriorityQueue;

public class MinOperationsToEqualize {
    public static int minOperationsToEqualize(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        // Priority queue to always process the smallest element first
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }

        int operations = 0;

        while (!pq.isEmpty()) {
            // Process the smallest element
            int currentMin = pq.poll();

            // If currentMin is already equal to max, no need to process
            if (currentMin == max) {
                continue;
            }

            // Calculate the difference needed to reach max
            int diff = max - currentMin;

            // If diff is less than or equal to 2, it can be processed directly
            if (diff <= 2) {
                operations++;
                // Update the element to the max value and re-add to the queue
                pq.offer(max);
            } else {
                // Determine the number of +2 operations needed
                int numTwoOps = diff / 2;
                // Determine the number of +1 operations needed
                int numOneOps = diff % 2;
                // Total operations needed for this element
                operations += numTwoOps + numOneOps;
                // Update the element to the max value and re-add to the queue
                pq.offer(max);
            }
        }

        return operations;
    }

    public static int minOperationsToEqualizeApproachTwo(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int oddCount = 0;

        // Find maximum value and calculate total sum of differences
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        for (int num : nums) {
            int diff = max - num;
            if (diff % 2 == 1) {
                oddCount++;
            }
            sum += diff;
        }

        // We need at least oddCount + 1 operations (since x >= oddCount)
        int x = oddCount;
        // Ensure that x - oddCount + y * 2 >= sum
        while (x * 2 < sum + oddCount) {
            x++;
        }

        // Calculate the minimum number of operations
        int operations = 2 * x;
        if (x < oddCount) {
            operations += 1; // Adjust for the odd case
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 2, 2 };
        System.out.println(minOperationsToEqualize(nums1)); // Output: 3
        System.out.println(minOperationsToEqualizeApproachTwo(nums1)); // Output: 3

        int[] nums2 = { 1, 2, 3 };
        System.out.println(minOperationsToEqualize(nums2)); // Output: 2
        System.out.println(minOperationsToEqualizeApproachTwo(nums2)); // Output: 2

        int[] nums3 = { 5, 8, 3 };
        System.out.println(minOperationsToEqualize(nums3)); // Output: 6
        System.out.println(minOperationsToEqualizeApproachTwo(nums3)); // Output: 6
    }
}
