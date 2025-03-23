package com.oa.company.cisco;

public class DigitSumCounter {
    // We will implement:
    // public static void funcCount(int inputNum1, int inputNum2)
    // which prints how many integers in [1..inputNum1] have digit sum == inputNum2.
    // If none, print -1.

    // --- Digit DP support structures ---
    private static Integer[][][] memo; // memo[pos][sumSoFar][isTight]
    private static int targetSum;
    private static int[] digits; // array of digits of the upper bound
    private static int nDigits; // number of digits in 'digits'

    public static void funcCount(int inputNum1, int inputNum2) {
        // Count how many numbers in [0..inputNum1] have digit sum = inputNum2.
        int count = countNumbersWithDigitSum(inputNum1, inputNum2);

        // Our problem wants [1..X], so if digit sum = 0, the number '0' would be
        // included.
        // - If inputNum2 == 0, we subtract 1 for the '0' itself (since '0' is not in
        // [1..X]).
        // - Otherwise, it doesn't affect the result.
        if (inputNum2 == 0) {
            count = Math.max(0, count - 1);
        }

        // Print according to the problem statement
        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    /**
     * Returns the number of integers in the range [0..N] whose digit sum ==
     * sumTarget.
     */
    private static int countNumbersWithDigitSum(int N, int sumTarget) {
        if (N < 0) {
            return 0; // no valid numbers
        }
        targetSum = sumTarget;

        // Extract digits of N into an array (most significant digit first).
        String s = String.valueOf(N);
        nDigits = s.length();
        digits = new int[nDigits];
        for (int i = 0; i < nDigits; i++) {
            digits[i] = s.charAt(i) - '0';
        }

        // Prepare memo array: dimension = [nDigits+1][sumTarget+1][2]
        // pos can go up to nDigits
        // sumSoFar can go up to sumTarget
        // isTight is either 0 or 1
        memo = new Integer[nDigits + 1][sumTarget + 1][2];

        // Start recursion from pos=0, sumSoFar=0, isTight=1
        return dp(0, 0, 1);
    }

    /**
     * Digit DP recursion.
     * pos - current digit index (0-based in 'digits')
     * sumSoFar - sum of chosen digits so far
     * isTight - 1 if the current prefix is "locked" to digits[pos],
     * 0 if we can freely choose [0..9]
     */
    private static int dp(int pos, int sumSoFar, int isTight) {
        // Base case: if we've assigned all digits
        if (pos == nDigits) {
            // If we hit exactly the target sum, that's 1 valid number
            return (sumSoFar == targetSum) ? 1 : 0;
        }

        // If already computed, return memoized value
        if (memo[pos][sumSoFar][isTight] != null) {
            return memo[pos][sumSoFar][isTight];
        }

        // Determine the upper limit for this digit
        int limit = (isTight == 1) ? digits[pos] : 9;
        int ways = 0;

        // Try all possible digits from 0..limit
        for (int dig = 0; dig <= limit; dig++) {
            int newSum = sumSoFar + dig;
            if (newSum <= targetSum) {
                // If we're tight and dig == limit, next state remains tight
                int nextTight = (isTight == 1 && dig == limit) ? 1 : 0;
                ways += dp(pos + 1, newSum, nextTight);
            }
        }

        memo[pos][sumSoFar][isTight] = ways;
        return ways;
    }

    // --- Demo usage ---
    public static void main(String[] args) {
        // Example from your prompt:
        // Input: X=20, Y=5 => Expected output: 2 (numbers are 5 and 14)
        funcCount(20, 5); // Should print "2"

        // Another quick check
        funcCount(15, 6); // For instance, numbers with sum=6 are: 6, 15, etc. => let's see what it prints
    }
}
