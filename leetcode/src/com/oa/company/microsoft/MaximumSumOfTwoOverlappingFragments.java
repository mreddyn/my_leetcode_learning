package com.oa.company.microsoft;

public class MaximumSumOfTwoOverlappingFragments {
    public static int solution(int[] A, int K, int L) {
        // Basic validation
        if (A == null || A.length == 0 || K <= 0 || L <= 0 || K > A.length || L > A.length) {
            return 0; // or throw an IllegalArgumentException
        }

        int n = A.length;

        // 1. Build prefix sums: prefix[i] = sum of A[0]..A[i-1], so subarray sum of
        // A[x..y] = prefix[y+1] - prefix[x]
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }

        // A helper to get subarray sum in O(1): sum of A[from..to]
        // Note: 'from' and 'to' are inclusive indices in A.
        // sum(A[from..to]) = prefix[to + 1] - prefix[from].
        // Make sure from <= to and both in [0..n-1].
        java.util.function.BiFunction<Integer, Integer, Integer> subarraySum = (from, to) -> prefix[to + 1]
                - prefix[from];

        int maxTotal = Integer.MIN_VALUE;

        // 2. Enumerate all subarray starts for the fragment of length K
        for (int startK = 0; startK <= n - K; startK++) {
            int endK = startK + K - 1;
            int sumK = subarraySum.apply(startK, endK);

            // 3. Enumerate all subarray starts for the fragment of length L
            for (int startL = 0; startL <= n - L; startL++) {
                int endL = startL + L - 1;
                int sumL = subarraySum.apply(startL, endL);

                if (endK < startL || endL < startK) {
                    // 4a. No overlap
                    // If the subarrays do not overlap, final sum is just sumK + sumL.
                    int totalNoOverlap = sumK + sumL;
                    maxTotal = Math.max(maxTotal, totalNoOverlap);
                } else {
                    // 4b. They overlap
                    // Overlap region is [max(startK, startL) .. min(endK, endL)]
                    int overlapStart = Math.max(startK, startL);
                    int overlapEnd = Math.min(endK, endL);
                    int overlapSum = subarraySum.apply(overlapStart, overlapEnd);

                    // The final sum = sumK + sumL - 3 * overlapSum
                    // Explanation:
                    // naive sum is sumK + sumL = sum of both subarrays counting overlap elements
                    // twice
                    // we want each overlap element to appear *once* and flipped sign => -x
                    // naive overlap portion is x + x = 2x
                    // desired overlap portion is -x
                    // difference for each x in overlap is -x - 2x = -3x => subtract 3*(overlapSum)
                    int totalOverlap = sumK + sumL - 3 * overlapSum;
                    maxTotal = Math.max(maxTotal, totalOverlap);
                }
            }
        }

        return maxTotal;
    }

    // A quick test
    public static void main(String[] args) {
        int[] A1 = { 1, 3, -4, 2, -1 };
        System.out.println(solution(A1, 3, 2)); // Expect 10 (example 1)

        int[] A2 = { -5, -3, -4 };
        System.out.println(solution(A2, 1, 3)); // Expect -2 (example 2)

        // Additional test
        int[] A3 = { 2, -1, 2, -3, 5 };
        // Let's do small tests manually if needed...
        System.out.println(solution(A3, 2, 2));
    }
}
