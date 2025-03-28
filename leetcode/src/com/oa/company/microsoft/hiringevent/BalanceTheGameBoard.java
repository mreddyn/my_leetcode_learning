package com.oa.company.microsoft.hiringevent;

public class BalanceTheGameBoard {
    public int solveGame(String L, int start) {
        int N = L.length(); // L has length N, board fields are 0..N
        int countA = 0, countB = 0;
        for (char c : L.toCharArray()) {
            if (c == 'a')
                countA++;
            else if (c == 'b')
                countB++;
        }

        // If already balanced
        if (countA == countB)
            return 0;

        // If difference is odd, balancing is impossible.
        if ((countA - countB) % 2 != 0)
            return -1;

        // target for the sum of weights on the flipped edges:
        int target = (countB - countA) / 2; // because we want 2*(sum) = -diff

        // Build prefix sum array P[0..N] where
        // P[0] = 0 and for i>=1: P[i] = sum_{j=0}^{i-1} (if L[j]=='b' then 1 else -1)
        int[] P = new int[N + 1];
        P[0] = 0;
        for (int i = 1; i <= N; i++) {
            P[i] = P[i - 1] + (L.charAt(i - 1) == 'b' ? 1 : -1);
        }

        int ans = Integer.MAX_VALUE;

        // Try routes going to the right of start (s < t)
        for (int t = start + 1; t <= N; t++) {
            if (P[t] - P[start] == target) {
                ans = Math.min(ans, t - start);
            }
        }

        // Try routes going to the left of start (s > t)
        for (int t = 0; t < start; t++) {
            if (P[start] - P[t] == target) {
                ans = Math.min(ans, start - t);
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    // A simple main() method for testing our solution with the provided examples.
    public static void main(String[] args) {
        var sol = new BalanceTheGameBoard();

        // Example 1:
        String L1 = "aaabab";
        int start1 = 0;
        System.out.println(sol.solveGame(L1, start1)); // Expected output: 1

        // Example 2:
        String L2 = "aaabab";
        int start2 = 6;
        System.out.println(sol.solveGame(L2, start2)); // Expected output: 5

        // Example 3:
        String L3 = "ababa";
        int start3 = 1;
        System.out.println(sol.solveGame(L3, start3)); // Expected output: -1

        // Example 4:
        String L4 = "babbaa";
        int start4 = 2;
        System.out.println(sol.solveGame(L4, start4)); // Expected output: 0
    }
}
