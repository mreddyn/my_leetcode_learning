package com.oa.company.microsoft;

public class FindFairIndexes {
    public int findFairIndex(int[] A, int[] B) {
        /*
         * You are given two arrays A and B consisting of N integers each.
         * 
         * Index K is named fair if the four sums A[0]+...A[K-1]), A[K]+...+A[N-1]),
         * B[0]+...+B[K-1]) and B[K]+...+B[N-1]) are all equal. In other words, K is the
         * index where the two arrays, A and B, can be split (into two non-empty arrays
         * each) in such a way that the sums of the resulting arrays' elements are
         * equal.
         */
        int n = A.length;
        int[] prefixSumA = new int[n + 1];
        int[] prefixSumB = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSumA[i + 1] = prefixSumA[i] + A[i];
            prefixSumB[i + 1] = prefixSumB[i] + B[i];
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            int sumA1 = prefixSumA[i];
            int sumA2 = prefixSumA[n] - prefixSumA[i];
            int sumB1 = prefixSumB[i];
            int sumB2 = prefixSumB[n] - prefixSumB[i];
            if (sumA1 == sumA2 && sumA2 == sumB1 && sumB1 == sumB2) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FindFairIndexes obj = new FindFairIndexes();

        // Example 1
        int[] A1 = { 4, -1, 0, 3 };
        int[] B1 = { -2, 5, 0, 3 };
        System.out.println(obj.findFairIndex(A1, B1)); // should be 2

        // Example 2
        int[] A2 = { 2, -2, -3, 3 };
        int[] B2 = { 0, 0, 4, -4 };
        System.out.println(obj.findFairIndex(A2, B2)); // should be 1

        // Example 3
        int[] A3 = { 4, -1, 0, 3 };
        int[] B3 = { -2, 5, 0, 3 };
        System.out.println(obj.findFairIndex(A3, B3)); // should be 2
    }
}
