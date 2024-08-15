package com.oa.company.tiktok;

public class MaxXOR {

    public static int findMaxXOR(int[] arr) {
        int maxXOR = Integer.MIN_VALUE;
        int n = arr.length;

        // Loop over all starting indices
        for (int i = 0; i < n; i++) {
            int currentXOR = 0;

            // XOR from index i to the end of the array
            for (int j = i; j < n; j++) {
                currentXOR ^= arr[j];
                maxXOR = Math.max(maxXOR, currentXOR);
            }
        }

        return maxXOR;
    }

    public static void main(String[] args) {
        int[] arr1 = { 8, 2, 4, 12, 1 };
        int[] arr2 = { 1, 2, 3 };
        int[] arr3 = { 0, 2, 5, 1 };
        int[] arr4 = { 1, 2, 1, 2, 4, 8 };
        int[] arr5 = { 1, 2, 1, 2, 4, 8, 4, 8 };

        System.out.println("Maximum XOR for arr1: " + findMaxXOR(arr1)); // Output: 14
        System.out.println("Maximum XOR for arr2: " + findMaxXOR(arr2)); // Output: 3
        System.out.println("Maximum XOR for arr3: " + findMaxXOR(arr3)); // Output: 7
        System.out.println("Maximum XOR for arr4: " + findMaxXOR(arr4)); // Output: 15
        System.out.println("Maximum XOR for arr5: " + findMaxXOR(arr5)); // Output: 15
    }
}
