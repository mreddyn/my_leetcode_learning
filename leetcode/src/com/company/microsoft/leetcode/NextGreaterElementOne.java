package com.company.microsoft.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementOne {
    private int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n, m;
        n = nums1.length;
        m = nums2.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> nextGreater = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int curElement = nums2[i];
            while (!stack.isEmpty() && curElement > stack.peek()) {
                int topElement = stack.pop();
                nextGreater.put(topElement, curElement);
            }
            stack.add(curElement);
        }

        while (!stack.isEmpty()) {
            int topElement = stack.pop();
            nextGreater.put(topElement, -1);
        }

        for (int i = 0; i < n; i++) {
            int greaterElement = nextGreater.get(nums1[i]);
            res[i] = greaterElement;
        }

        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementOne nextGreaterElementOne = new NextGreaterElementOne();
        System.out.println(nextGreaterElementOne.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }));
    }
}
