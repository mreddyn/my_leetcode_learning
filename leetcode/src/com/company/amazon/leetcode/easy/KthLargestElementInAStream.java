package com.company.amazon.leetcode.easy;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    private PriorityQueue<Integer> pQueue;
    private int kSize;

    public KthLargestElementInAStream(int k, int[] nums) {
        pQueue = new PriorityQueue<>((a, b) -> a - b);
        kSize = k;
        for (int num : nums) {
            pQueue.add(num);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }
    }

    public int add(int val) {
        pQueue.add(val);
        if (pQueue.size() > kSize) {
            pQueue.poll();
        }
        return pQueue.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAStream kAStream = new KthLargestElementInAStream(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kAStream.add(3));
        System.out.println(kAStream.add(5));
        System.out.println(kAStream.add(10));
        System.out.println(kAStream.add(9));
        System.out.println(kAStream.add(4));
    }
}
