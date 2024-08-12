package com.oa.company.amazon;

import java.util.Arrays;

public class MaximumFinalElement {

    public static int maximumFinal(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Initialize the first element to 1
        arr[0] = 1;

        // Step 3: Build the array to satisfy the constraints
        for (int i = 1; i < arr.length; i++) {
            // The current element should be either the previous element + 1 or the current
            // element itself, whichever is smaller
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        // Step 4: Return the last element
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 1, 3, 4 };
        System.out.println(maximumFinal(arr1)); // Output: 4

        int[] arr2 = { 10, 20, 30, 40, 50 };
        System.out.println(maximumFinal(arr2)); // Output: 5

        int[] arr3 = { 1, 2, 3, 4, 5 };
        System.out.println(maximumFinal(arr3)); // Output: 5
    }
}
