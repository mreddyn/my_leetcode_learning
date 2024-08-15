package com.oa.company.tiktok;

public class MaximizeDanceMoves {
    // https://leetcode.com/discuss/interview-question/4939738/Tiktok-OA

    public static int maximizeConsecutiveOnes(String s, int k) {
        int n = s.length();
        int left = 0, right = 0;
        int maxConsecutiveOnes = 0;
        int zerosInWindow = 0;

        while (right < n) {
            // If we encounter a '0', we consider it as a flip
            if (s.charAt(right) == '0') {
                zerosInWindow++;
            }

            // If the number of flips (i.e., zeros in the window) exceeds k, move the left
            // pointer
            while (zerosInWindow > k) {
                if (s.charAt(left) == '0') {
                    zerosInWindow--;
                }
                left++;
            }

            // Calculate the max number of consecutive '1's with the current window
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left + 1);
            right++;
        }

        // The maximum consecutive pairs of '1's is maxConsecutiveOnes - 1
        // because two consecutive '1's form one pair
        return maxConsecutiveOnes - 1;
    }

    public static void main(String[] args) {
        String s = "01010";
        int k = 2;
        System.out.println(maximizeConsecutiveOnes(s, k)); // Output: 3
    }
}
