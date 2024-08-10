package com.leetcode_daily_challenge;

public class KnightDialer {
    int[][] possibleJumps = {
            { 4, 6 },
            { 6, 8 },
            { 7, 9 },
            { 4, 8 },
            { 3, 9, 0 },
            {},
            { 1, 7, 0 },
            { 2, 6 },
            { 1, 3 },
            { 2, 4 }
    };
    int[][] memo;
    int MOD = 1000000007;
    int n;

    private int knightDialer(int n) {
        this.n = n;
        memo = new int[n + 1][10];
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dfs(n - 1, i)) % MOD;
        }
        return result;
    }

    private int dfs(int remain, int square) {
        if (remain == 0) {
            return 1;
        }
        if (memo[remain][square] != 0) {
            return memo[remain][square];
        }
        int result = 0;
        for (int nextSquare : possibleJumps[square]) {
            result = (result + dfs(remain - 1, nextSquare)) % MOD;
        }
        memo[remain][square] = result;
        return result;
    }

    public static void main(String[] args) {
        KnightDialer knightDialer = new KnightDialer();
        System.out.println(knightDialer.knightDialer(1));
        System.out.println(knightDialer.knightDialer(2));
        System.out.println(knightDialer.knightDialer(3));
        System.out.println(knightDialer.knightDialer(4));
        System.out.println(knightDialer.knightDialer(5));
        System.out.println(knightDialer.knightDialer(6));
        System.out.println(knightDialer.knightDialer(7));
        System.out.println(knightDialer.knightDialer(8));
        System.out.println(knightDialer.knightDialer(9));
        System.out.println(knightDialer.knightDialer(10));
        System.out.println(knightDialer.knightDialer(5000));
    }
}
