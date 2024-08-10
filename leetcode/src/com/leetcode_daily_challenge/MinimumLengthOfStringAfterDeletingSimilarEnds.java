package com.leetcode_daily_challenge;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    private int minimumLength(String s) {
        int n = s.length();
        int leftPointer, rightPointer;
        leftPointer = 0;
        rightPointer = n - 1;
        while (leftPointer < rightPointer) {
            if (s.charAt(leftPointer) == s.charAt(rightPointer)) {
                char c = s.charAt(leftPointer);
                while (leftPointer <= rightPointer && s.charAt(leftPointer) == c) {
                    leftPointer++;
                }
                while (leftPointer <= rightPointer && s.charAt(rightPointer) == c) {
                    rightPointer--;
                }
            } else {
                break;
            }
        }

        return rightPointer - leftPointer + 1;
    }

    public static void main(String[] args) {
        MinimumLengthOfStringAfterDeletingSimilarEnds minimumLengthOfStringAfterDeletingSimilarEnds = new MinimumLengthOfStringAfterDeletingSimilarEnds();
        // System.out.println(minimumLengthOfStringAfterDeletingSimilarEnds.minimumLength("cabaabac"));
        // System.out.println(minimumLengthOfStringAfterDeletingSimilarEnds.minimumLength("aabccabba"));
        System.out.println(minimumLengthOfStringAfterDeletingSimilarEnds.minimumLength("abbbbbbbbbbbbbbbbbbba"));
    }
}
