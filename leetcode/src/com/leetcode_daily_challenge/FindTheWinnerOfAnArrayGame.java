package com.leetcode_daily_challenge;

public class FindTheWinnerOfAnArrayGame {
    private int getWinner(int[] arr, int k) {
        if (k == 1) {
            return Math.max(arr[0], arr[1]);
        }
        int curr = arr[0];
        int winStreak = 0;
        for (int index = 1; index < arr.length; index++) {
            int opponent = arr[index];
            if (curr > opponent) {
                winStreak++;
            } else {
                curr = opponent;
                winStreak = 1;
            }
            if (winStreak == k) {
                break;
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        FindTheWinnerOfAnArrayGame findTheWinnerOfAnArrayGame = new FindTheWinnerOfAnArrayGame();
        int[] arr = { 2, 1, 3, 5, 4, 6, 7 };
        int k = 2;
        int result = findTheWinnerOfAnArrayGame.getWinner(arr, k);
        System.out.println(result);
    }
}
