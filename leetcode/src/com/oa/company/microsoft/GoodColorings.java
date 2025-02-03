package com.oa.company.microsoft;

public class GoodColorings {
    static final long MOD = 1000000007;
    static long count = 0;

    public static void main(String[] args) {
        // Example usage:
        // 1) Read input size N
        // 2) Read the array A of size N
        // 3) Call solve(A) and print the result
        //
        // For demonstration, we'll show hardcoded examples here:

        // Example 1: A = [1, 2]
        int[] A1 = { 1, 2 };
        System.out.println(solve(A1)); // Expected 2

        // Example 2: A = [3, 5, 7]
        int[] A2 = { 3, 5, 7 };
        System.out.println(solve(A2)); // Expected 0

        // Example 3: A = [2, 3, 9]
        int[] A3 = { 2, 3, 9 };
        System.out.println(solve(A3)); // Expected 6
    }

    // Main driver that sets up the DFS and returns the count mod 1e9+7
    public static long solve(int[] A) {
        count = 0; // reset global counter
        dfs(A, 0, 0, 0);
        return count % MOD;
    }

    /**
     * DFS to explore all colorings:
     * index: current element index in A
     * x: current XOR of all white-colored elements
     * y: current XOR of all black-colored elements
     *
     * At each element, you can:
     * - Color it white => (x ^ A[index], y)
     * - Color it black => (x, y ^ A[index])
     * - Color it "none" => (x, y) (no change)
     */
    private static void dfs(int[] A, int index, int x, int y) {
        // If we've assigned colors to all elements:
        if (index == A.length) {
            // Check if both x and y are > 0 and one divides the other
            if (x > 0 && y > 0 && (x % y == 0 || y % x == 0)) {
                count = (count + 1) % MOD;
            }
            return;
        }

        // Option 1: Color A[index] white
        dfs(A, index + 1, x ^ A[index], y);

        // Option 2: Color A[index] black
        dfs(A, index + 1, x, y ^ A[index]);

        // Option 3: Do nothing with A[index]
        dfs(A, index + 1, x, y);
    }
}
