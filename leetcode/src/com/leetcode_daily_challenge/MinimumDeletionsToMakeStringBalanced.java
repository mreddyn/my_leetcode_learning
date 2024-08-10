package com.leetcode_daily_challenge;

import java.util.ArrayDeque;

public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        int n = s.length(), minDeletionsCount = n, aCount = 0, bCount = 0;
        int[] countA = new int[n];
        int[] countB = new int[n];

        for (int i = 0; i < n; i++) {
            countB[i] = bCount;
            if (s.charAt(i) == 'b') {
                bCount++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            countA[i] = aCount;
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        for (int i = 0; i < n; i++) {
            minDeletionsCount = Math.min(minDeletionsCount, countA[i] + countB[i]);
        }
        return minDeletionsCount;
    }

    public int minimumDeletionsApproachTwo(String s) {
        int n = s.length(), minDeletionsCount = n, aCount = 0, bCount = 0;
        int[] countA = new int[n];
        int[] countB = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            countA[i] = aCount;
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        for (int i = 0; i < n; i++) {
            countB[i] = bCount;
            minDeletionsCount = Math.min(minDeletionsCount, countA[i] + countB[i]);
            if (s.charAt(i) == 'b') {
                bCount++;
            }
        }
        return minDeletionsCount;
    }

    public int minimumDeletionsApproachThree(String s) {
        int n = s.length(), minDeletionsCount = n, aCount = 0, bCount = 0;
        for (int i = 0; i < n; i++) {
            // count 'a's
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                aCount--;
            }

            minDeletionsCount = Math.min(minDeletionsCount, aCount + bCount);
            if (s.charAt(i) == 'b') {
                bCount++;
            }
        }
        return minDeletionsCount;
    }

    public int minimumDeletionsApproachFour(String s) {
        int n = s.length(), minDeletionsPairCount = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            if (!stack.isEmpty() && (currentChar == 'a' && stack.peek() == 'b')) {
                stack.pop();
                minDeletionsPairCount++;
            } else {
                stack.push(currentChar);
            }
        }
        return minDeletionsPairCount;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeStringBalanced mBalanced = new MinimumDeletionsToMakeStringBalanced();
        mBalanced.minimumDeletions("aababbab");
    }
}
