package com.leetcode_daily_challenge;

public class FillingBookcaseShelves {
    private int[][] memo;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        // cache to store the results
        memo = new int[books.length][shelfWidth + 1];

        return dp(books, shelfWidth, 0, shelfWidth, 0);
    }

    private int dp(int[][] books, int shelfWidth, int i, int remainingShelfWidth, int maxHeight) {
        int[] currentBook = books[i];
        int currentBookHeight = currentBook[1];
        int currentBookWidth = currentBook[0];
        int maxHeightUpdated = Math.max(maxHeight, currentBookHeight);

        if (i == books.length - 1) {
            // if it is the last book, store it in the current shelf if possible
            if (remainingShelfWidth >= currentBookWidth) {
                return maxHeightUpdated;
            }
            return maxHeight + currentBookHeight;
        }

        if (memo[i][remainingShelfWidth] != 0) {
            return memo[i][remainingShelfWidth];
        } else {
            // option 1, if we put the current book on new shelf
            int optionOneHeight = maxHeight
                    + dp(books, shelfWidth, i + 1, shelfWidth - currentBookWidth, currentBookHeight);
            if (remainingShelfWidth >= currentBookWidth) {
                // store the book on current shelf
                int optionTwoHeight = dp(books, shelfWidth, i + 1, remainingShelfWidth - currentBookWidth,
                        maxHeightUpdated);

                memo[i][remainingShelfWidth] = Math.min(optionOneHeight, optionTwoHeight);
                return memo[i][remainingShelfWidth];
            }
            memo[i][remainingShelfWidth] = optionOneHeight;
        }

        return memo[i][remainingShelfWidth];
    }
}
