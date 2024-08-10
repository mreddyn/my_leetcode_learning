package com.leetcode_daily_challenge;

public class NumberOfWonderfulSubStrings {
    private long wonderfulSubStrings(String word) {
        long count = 0, cnt[] = new long[1024];
        int mask = 0;
        cnt[0] = 1;
        for (char ch : word.toCharArray()) {
            mask = mask ^ (1 << (ch - 'a'));
            count += cnt[mask];
            for (int i = 0; i < 10; i++) {
                count += cnt[mask ^ (1 << i)];
            }
            cnt[mask]++;
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfWonderfulSubStrings numberOfWonderfulSubStrings = new NumberOfWonderfulSubStrings();
        System.out.println(numberOfWonderfulSubStrings.wonderfulSubStrings("aba"));
    }
}
