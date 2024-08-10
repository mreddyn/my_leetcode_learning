package com.leetcode_daily_challenge;

public class CountTripletsThatFormTwoArraysOfEqualXOR {
    private int countTriplets(int[] arr) {
        int tripletsCount = 0, n = arr.length;
        /*
         * if a = arr[i]^arr[i+1]..arr[j-1]
         * and b = arr[j]^arr[j+1]..arr[k]
         * if a == b for a triplet i < j <= k then a ^ b = 0
         * so, we need to find a subArray whose XOR value is zero
         */
        int xorValue = 0;
        for (int i = 0; i < n; i++) {
            xorValue = arr[i];
            for (int j = i + 1; j < n; j++) {
                xorValue ^= arr[j];
                if (xorValue == 0) {
                    tripletsCount += (j - i);
                }
            }
        }
        return tripletsCount;
    }

    public static void main(String[] args) {
        CountTripletsThatFormTwoArraysOfEqualXOR cArraysOfEqualXOR = new CountTripletsThatFormTwoArraysOfEqualXOR();
        System.out.println(cArraysOfEqualXOR.countTriplets(new int[] { 2, 3, 1, 6, 7 }));
    }
}
