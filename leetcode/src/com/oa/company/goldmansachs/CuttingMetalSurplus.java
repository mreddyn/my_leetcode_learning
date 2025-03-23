package com.oa.company.goldmansachs;

public class CuttingMetalSurplus {
    public int maxProfit(int[] lengths, int costPerCut, int salePrice) {
        int maxLength = 0;
        for (int length : lengths) {
            maxLength = Math.max(maxLength, length);
        }

        int bestProfit = Integer.MIN_VALUE;

        // Consider every possible length from 1 to the maximum length found in the rods
        for (int saleLength = 1; saleLength <= maxLength; saleLength++) {
            int totalRods = 0;
            int totalCuts = 0;

            for (int rod : lengths) {
                if (rod >= saleLength) {
                    int numRods = rod / saleLength;
                    totalRods += numRods;
                    int leftover = rod % saleLength;
                    if (leftover > 0) {
                        totalCuts += numRods; // Each full rod length requires a cut
                    } else {
                        totalCuts += (numRods - 1); // No leftover, one less cut
                    }
                }
            }

            int profit = totalRods * saleLength * salePrice - totalCuts * costPerCut;
            bestProfit = Math.max(bestProfit, profit);
        }

        return bestProfit;
    }

    public static void main(String[] args) {
        CuttingMetalSurplus obj = new CuttingMetalSurplus();
        int[] lengths = { 30, 59, 110 };
        int costPerCut = 1;
        int salePrice = 10;
        System.out.println(obj.maxProfit(lengths, costPerCut, salePrice)); // 1913
    }
}
