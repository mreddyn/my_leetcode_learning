package com.oa.company.amazon;

public class DiscountPairs {

    public static int getDiscountPairs(int x, int[] prices) {
        int[] remainderCount = new int[x];
        int pairCount = 0;

        // Calculate frequency of each remainder
        for (int price : prices) {
            int remainder = price % x;
            remainderCount[remainder]++;
        }

        // Count pairs
        // Pairing remainders with their complements
        for (int r = 1; r < x / 2; r++) {
            pairCount += remainderCount[r] * remainderCount[x - r];
        }

        // Special case for remainder 0 (pairs within this group)
        pairCount += (remainderCount[0] * (remainderCount[0] - 1)) / 2;

        // Special case when x is even and remainder is x/2 (pairs within this group)
        if (x % 2 == 0) {
            pairCount += (remainderCount[x / 2] * (remainderCount[x / 2] - 1)) / 2;
        }

        return pairCount;
    }

    public static void main(String[] args) {
        int x = 60;
        int[] prices = { 31, 25, 85, 29, 35 };
        System.out.println(getDiscountPairs(x, prices)); // Output: 3
    }
}
