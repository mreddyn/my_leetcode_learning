package com.leetcode_daily_challenge;

public class CountOfMatchesInTournament {
    private int numberOfMatches(int n) {
        int matchesCount = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                matchesCount += n / 2;
                n = n / 2;
            } else {
                matchesCount += ((n - 1) / 2) + 1;
                n = (n - 1) / 2;
            }
        }
        return matchesCount;
    }

    public static void main(String[] args) {
        CountOfMatchesInTournament countOfMatchesInTournament = new CountOfMatchesInTournament();
        System.out.println(countOfMatchesInTournament.numberOfMatches(7));
    }
}
