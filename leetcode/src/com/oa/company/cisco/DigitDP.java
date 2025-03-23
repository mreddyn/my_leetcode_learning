package com.oa.company.cisco;

import java.util.ArrayList;
import java.util.Collections;

public class DigitDP {

    // Memo array: dimensions [position][sumSoFar][isTight? 0 or 1]
    static Integer[][][] memo;
    static ArrayList<Integer> digits;
    static int S; // The target digit sum

    // Returns count of integers in [0..N] whose digit sum == sumTarget
    public static int countNumbersWithDigitSum(int N, int sumTarget) {
        S = sumTarget;
        digits = new ArrayList<>();

        // Extract digits of N (most significant digit first)
        while (N > 0) {
            digits.add(N % 10);
            N /= 10;
        }
        Collections.reverse(digits);

        // Prepare memo: pos can be up to digits.size(), sumSoFar can be up to
        // sumTarget, isTight is 0/1
        memo = new Integer[digits.size() + 1][sumTarget + 1][2];

        // Start recursion
        return dp(0, 0, 1);
    }

    // Digit DP function
    // pos: current digit index (0-based)
    // sumSoFar: sum of chosen digits so far
    // isTight: 1 if we are bound by the digit of 'digits[pos]', 0 if free to use up
    // to 9
    private static int dp(int pos, int sumSoFar, int isTight) {
        // Base case: if we've placed all digits
        if (pos == digits.size()) {
            // If sumSoFar == S, we have exactly the sum we want
            return (sumSoFar == S) ? 1 : 0;
        }

        // If result already computed, return it
        if (memo[pos][sumSoFar][isTight] != null) {
            return memo[pos][sumSoFar][isTight];
        }

        int limit = (isTight == 1) ? digits.get(pos) : 9;
        int ways = 0;

        // Try all possible digits from 0..limit
        for (int digit = 0; digit <= limit; digit++) {
            // Only proceed if we won't exceed the target sum
            if (sumSoFar + digit <= S) {
                ways += dp(pos + 1,
                        sumSoFar + digit,
                        (isTight == 1 && digit == limit) ? 1 : 0);
            }
        }

        memo[pos][sumSoFar][isTight] = ways;
        return ways;
    }

    // A quick demo
    public static void main(String[] args) {
        int X = 20;
        int Y = 5;
        int count = countNumbersWithDigitSum(X, Y);

        // If no numbers found, print -1
        System.out.println(count == 0 ? -1 : count);
    }
}
