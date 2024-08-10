package com.neetcode.roadmap.arraysAndHashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        /*
         * Push all elements into HashSet to keep track of unique elements
         * Now iterate through HashSet, keep going in one direction (->)
         * i.e, for Integer (num), see if set does not contains num-1,
         * then search for num+1, num+2, num+3,..so on when this loop breaks calculate
         * the streak length
         */
        int n = nums.length;
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            seen.add(nums[i]);
        }
        int maxSequenceLength = 0;
        for (int num : seen) {
            int prev = num - 1;
            if (!seen.contains(prev)) {
                int next = num + 1;
                while (seen.contains(next)) {
                    next = next + 1;
                }
                maxSequenceLength = Math.max(maxSequenceLength, next - num);
            }
        }

        return maxSequenceLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestCSequence = new LongestConsecutiveSequence();
        System.out.println(longestCSequence.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
    }
}
