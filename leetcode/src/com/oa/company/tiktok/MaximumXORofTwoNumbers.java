package com.oa.company.tiktok;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORofTwoNumbers {
    // https://leetcode.com/discuss/interview-question/4734570/tiktok-OA
    public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaximumXOR(new int[] { 8, 2, 4, 12, 1 }));
    }
}
