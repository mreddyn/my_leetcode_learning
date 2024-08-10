package com.oa.company.amazon;

public class StockAnalysis {

    private static int maxLossMonths;

    public static void main(String[] args) {
        int[] pnl = { 1, 1, 1, 1, 1 };
        maxLossMonths = calculateMaxLossMonths(pnl);
        System.out.println("Maximum number of loss months: " + maxLossMonths);
    }

    public static int calculateMaxLossMonths(int[] pnl) {
        int[] cumulativePnl = new int[pnl.length];
        cumulativePnl[0] = pnl[0];
        // Calculating the initial cumulative PnL
        for (int i = 1; i < pnl.length; i++) {
            cumulativePnl[i] = cumulativePnl[i - 1] + pnl[i];
        }

        maxLossMonths = 0;
        findMaxLossMonths(pnl, cumulativePnl, 0, 0);
        return maxLossMonths;
    }

    private static void findMaxLossMonths(int[] pnl, int[] cumulativePnl, int index, int currentLossMonths) {
        if (index == pnl.length) {
            // If all cumulative PnL values are positive, check if we have a new maximum
            if (allPositive(cumulativePnl)) {
                maxLossMonths = Math.max(maxLossMonths, currentLossMonths);
            }
            return;
        }

        // Choice 1: Do not invert the PnL for the current month
        findMaxLossMonths(pnl, cumulativePnl, index + 1, currentLossMonths);

        // Choice 2: Try inverting the PnL for the current month if it's not already
        // negative
        if (pnl[index] > 0) {
            // Invert the PnL for the current and subsequent months
            for (int i = index; i < pnl.length; i++) {
                cumulativePnl[i] -= 2 * pnl[index];
            }
            findMaxLossMonths(pnl, cumulativePnl, index + 1, currentLossMonths + 1);
            // Revert the inversion
            for (int i = index; i < pnl.length; i++) {
                cumulativePnl[i] += 2 * pnl[index];
            }
        }
    }

    // Utility method to check if all elements in the array are positive
    private static boolean allPositive(int[] array) {
        for (int value : array) {
            if (value <= 0) {
                return false;
            }
        }
        return true;
    }
}
