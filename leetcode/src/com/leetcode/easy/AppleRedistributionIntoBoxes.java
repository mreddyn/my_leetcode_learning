package com.leetcode.easy;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        /*
         * Since we only care about the min boxes required. we can just sort the
         * capacity array
         * and calculate suffixSum.
         * Additionally calculate the totalApples that we need to fill in the boxes.
         * Finally search this totalApples in suffixSum array by doing binary search for
         * min index
         * to keep all the apples using min boxes.
         */
        int minBoxes = 0, totalApples = 0, totalBoxes = capacity.length;
        for (int i = 0; i < apple.length; i++) {
            totalApples += apple[i];
        }
        Arrays.sort(capacity);
        int[] suffixSum = new int[totalBoxes];
        int boxSum = 0;
        for (int i = totalBoxes - 1; i >= 0; i--) {
            boxSum += capacity[i];
            suffixSum[i] = boxSum;
        }

        // reverse the suffixSum array
        reverse(suffixSum);

        // Binary search the index in suffixSum
        minBoxes = binarySearch(suffixSum, totalApples);

        return minBoxes;
    }

    private int binarySearch(int[] suffixSum, int target) {
        int left = 0, right = suffixSum.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (suffixSum[mid] == target) {
                return mid + 1;
            }
            if (suffixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left + 1;
    }

    private void reverse(int[] suffixSum) {
        int left = 0, right = suffixSum.length - 1;
        while (left < right) {
            int temp = suffixSum[left];
            suffixSum[left] = suffixSum[right];
            suffixSum[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        AppleRedistributionIntoBoxes aBoxes = new AppleRedistributionIntoBoxes();
        System.out.println(aBoxes.minimumBoxes(new int[] { 1, 3, 2 }, new int[] { 4, 3, 1, 5, 2 }));
    }
}
