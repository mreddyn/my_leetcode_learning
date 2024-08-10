package com.company.servicenow;

import java.util.PriorityQueue;

public class FindKthLargestElementInArray {
    private int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        FindKthLargestElementInArray findKthLargestElementInArray = new FindKthLargestElementInArray();
        System.out.println(findKthLargestElementInArray.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
    }
}
