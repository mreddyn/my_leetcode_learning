package com.oa.company.goldmansachs;

import java.util.Arrays;

public class FindNiceness {
    private int bestNiceness; // global maximum niceness
    private boolean[] used; // track which b[i] are used in current permutation

    /**
     * Finds the maximum possible niceness for Sonu's arrangement
     * that matches Ramu's up/down pattern.
     *
     * @param n number of chalks
     * @param a Ramu's chalk lengths in a fixed order
     * @param b Sonu's chalk lengths (may be rearranged)
     * @return maximum niceness of any valid arrangement
     */
    public int findMaxNiceness(int n, int[] a, int[] b) {
        // Build the up/down pattern from Ramu's arrangement
        boolean[] upDownPattern = new boolean[n - 1];
        for (int i = 0; i < n - 1; i++) {
            upDownPattern[i] = (a[i] < a[i + 1]); // true means "up", false means "down"
        }

        // Sort b for convenience (not strictly required, but often helpful)
        Arrays.sort(b);

        // Prepare for backtracking
        bestNiceness = 0;
        used = new boolean[n];
        int[] perm = new int[n];

        // Generate all permutations of b (with constraints)
        backtrack(0, perm, upDownPattern, b);

        return bestNiceness;
    }

    /**
     * Backtracking function to build permutations of b in perm[].
     *
     * @param idx           current position we are trying to fill
     * @param perm          the partial arrangement being built
     * @param upDownPattern array that indicates if consecutive positions are "up"
     *                      or "down"
     * @param b             sorted array of Sonu's chalks
     */
    private void backtrack(int idx, int[] perm, boolean[] upDownPattern, int[] b) {
        int n = b.length;

        // If we placed all n chalks, compute niceness and update bestNiceness
        if (idx == n) {
            int niceness = 0;
            for (int i = 0; i < n - 1; i++) {
                niceness += Math.abs(perm[i] - perm[i + 1]);
            }
            bestNiceness = Math.max(bestNiceness, niceness);
            return;
        }

        // Try each chalk b[i] that hasn't been used yet
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                // If idx > 0, we must respect the pattern for (idx-1, idx)
                if (idx > 0) {
                    boolean neededUp = upDownPattern[idx - 1]; // true => perm[idx-1] < perm[idx]
                    if (neededUp && b[i] <= perm[idx - 1]) {
                        // We needed an 'up' but b[i] is not larger
                        continue;
                    }
                    if (!neededUp && b[i] >= perm[idx - 1]) {
                        // We needed a 'down' but b[i] is not smaller
                        continue;
                    }
                }

                // Place chalk b[i] in perm[idx]
                perm[idx] = b[i];
                used[i] = true;

                // Recurse for next position
                backtrack(idx + 1, perm, upDownPattern, b);

                // Backtrack / unchoose
                used[i] = false;
            }
        }
    }

    // A small main to demonstrate usage
    public static void main(String[] args) {
        FindNiceness solver = new FindNiceness();

        // Example from the prompt:
        // Ramu's chalks: a = [7, 1, 4, 9] => pattern: down, up, up
        // Sonu's chalks: b = [1, 2, 3, 4]
        // The best arrangement is [2, 4, 1, 3] with niceness = 7
        int[] a = { 7, 1, 4, 9 };
        int[] b = { 1, 2, 3, 4 };
        int n = a.length;

        int result = solver.findMaxNiceness(n, a, b);
        System.out.println(result); // Should print 7
    }
}
