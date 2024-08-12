package com.oa.company.amazon;

public class MaximumProfitableGroups {

    public static long countMaximumProfitableGroups(int[] stockPrice) {
        int n = stockPrice.length;
        long count = 0;

        // Traverse and count for maximums ending at each index
        for (int i = 0; i < n; i++) {
            int currentMax = stockPrice[i];
            for (int j = i; j >= 0; j--) {
                currentMax = Math.max(currentMax, stockPrice[j]);
                if (currentMax == stockPrice[i] || currentMax == stockPrice[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] stockPrice1 = { 3, 1, 3, 5 };
        System.out.println(countMaximumProfitableGroups(stockPrice1)); // Output: 10

        int[] stockPrice2 = { 1, 5, 2 };
        System.out.println(countMaximumProfitableGroups(stockPrice2)); // Output: 5
    }
}
