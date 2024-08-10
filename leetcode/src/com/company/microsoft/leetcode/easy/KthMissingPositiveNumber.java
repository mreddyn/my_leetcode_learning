package com.company.microsoft.leetcode.easy;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        /*
         * Maintain a count array which keeps track of the numbers appeared in the
         * array(arr).
         * If there is any missing number then the count of that number is zero.
         * We will do a loop until 1001 to check for any missing numbers.
         * if the count is one we continue, else we will decrease k. and return missing
         * when k reaches zero
         * 
         * 
         */
        int n = arr.length, missingNumber;
        int[] count = new int[1001];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (missingNumber = 1; missingNumber < 1001; missingNumber++) {
            if (count[missingNumber] == 0) {
                k--;
            }
            if (k == 0) {
                return missingNumber;
            }
        }

        // if k is still not zero then
        missingNumber = missingNumber + k - 1;

        return missingNumber;
    }

    public static void main(String[] args) {
        KthMissingPositiveNumber kNumber = new KthMissingPositiveNumber();
        System.out.println(kNumber.findKthPositive(new int[] { 2, 3, 4, 7, 11 }, 5));
        System.out.println(kNumber.findKthPositive(new int[] { 1, 2, 3, 4 }, 4));
    }
}
