package com.oa.company.amazon;

import java.util.Arrays;

public class MaxSumOfMedians {
    public int maxSumOfMedians(int[] packets, int channels) {
        /*
         * Median Calculation:
         * 
         * The median is the middle element of a sorted array. If the array has an even
         * number of elements, the median is the average of the two middle elements.
         * The goal is to maximize the sum of these medians across all channels.
         * Optimal Strategy:
         * 
         * To maximize the median, we should place larger packets in separate channels,
         * because the median of a larger number contributes more to the sum.
         * Greedy Approach:
         * 
         * Sort the packets in ascending order.
         * Start by assigning the largest packets to each channel to ensure that each
         * channel has at least one packet.
         * Then, assign the remaining packets in a way that maximizes the median value
         * in the channels.
         */

        // sort the packets
        Arrays.sort(packets);
        int n = packets.length, k = channels, packetsIndex = n - 1;
        double sumMedians = 0.0;

        // Distribute the k packets into k channels
        while (k > 0) {
            sumMedians += packets[packetsIndex--];
            k--;
        }

        // every channel has one packet where channels == packets.length
        if (packetsIndex < 0) {
            return (int) Math.ceil(sumMedians);
        }

        // assign remaining packets to first channel and adjust its median
        packetsIndex++;
        sumMedians -= packets[packetsIndex];
        if (packetsIndex % 2 == 0) {
            // middle element is median for odd number of packets
            sumMedians += packets[packetsIndex / 2];
            return (int) Math.ceil(sumMedians);
        } else {
            // median is average of middle two elements
            sumMedians += (double) ((packets[packetsIndex / 2] + packets[(packetsIndex / 2) + 1]) / 2);
            return (int) Math.ceil(sumMedians);
        }
    }

    public static void main(String[] args) {
        MaxSumOfMedians medians = new MaxSumOfMedians();
        System.out.println(medians.maxSumOfMedians(new int[] { 1, 2, 3, 4, 5 }, 2));
    }
}
