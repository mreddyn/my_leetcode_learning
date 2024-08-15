package com.oa.company.tiktok;

public class MinimumCycles {
    public static int minOperationsToEqualize(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        // Determine the maximum value in the array
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // Check both max and max + 1 as target values
        return Math.min(calculateOperations(arr, max), calculateOperations(arr, max + 1));
    }

    private static int calculateOperations(int[] arr, int target) {
        int oddOperations = 0;
        int evenOperations = 0;
        int operationCount = 0;

        // Calculate the number of operations needed to make all elements equal to the
        // target
        for (int num : arr) {
            int diff = target - num;
            if (diff > 0) {
                // Number of +2 operations required
                evenOperations += diff / 2;
                // Number of +1 operations required
                oddOperations += diff % 2;
            }
        }

        // We need to process odd operations first, then even operations
        // To ensure that we are always making progress, and the minimal number of total
        // operations
        // Since each operation number alternates, compute total operations accordingly
        operationCount = oddOperations + evenOperations * 2;

        return operationCount;
    }

    public static int minOperationsToEqualizeApproachTwo(int[] arr) {
        int arraySum, smallest, arr_size = arr.length;
        arraySum = 0;
        smallest = arr[0];
        for (int i = 0; i < arr_size; i++) {
            // If current element is smaller than update smallest
            if (arr[i] < smallest)
                smallest = arr[i];

            // find array sum
            arraySum += arr[i];
        }

        int minOperation = arraySum - arr_size * smallest;

        // Print min operation required
        System.out.println("Minimum Operation = " + minOperation);
        return minOperation;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4 };
        System.out.println(minOperationsToEqualize(arr1)); // Output: 4
        System.out.println(minOperationsToEqualizeApproachTwo(arr1)); // Output: 4

        int[] arr2 = { 3, 7, 5 };
        System.out.println(minOperationsToEqualize(arr2)); // Output: 7
        System.out.println(minOperationsToEqualizeApproachTwo(arr2)); // Output: 7

        int[] arr3 = { 1, 1, 1 };
        System.out.println(minOperationsToEqualize(arr3)); // Output: 0
        System.out.println(minOperationsToEqualizeApproachTwo(arr3)); // Output: 0
    }
}
