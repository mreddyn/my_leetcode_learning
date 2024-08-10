package com.company.amazon.leetcode;

public class MinimumAdjacentSwapsToMakeValidArray {
    private int minimumSwaps(int[] nums) {
        int minSwaps = 0, n = nums.length, largestEleIndex = 0, smallestEleIndex = 0,
                largestEle = nums[0], smallestEle = nums[0];

        /*
         * calculate smallest element index which is closer to 0th position
         * calculate largest element index which is closer to n-1th position
         * if the smallest element index is less than largest element index then
         * minSwaps required are sum of (no.of swaps to move largestEle t0 n-1th
         * position) and
         * (no.of swaps to move smallestEle to 0th position)
         * 
         * if the smallest element index is greater than largest element then move
         * largest ele to last
         * and calculate smallest element index again
         */

        for (int i = 0; i < n; i++) {
            if (largestEle <= nums[i]) {
                largestEleIndex = i;
                largestEle = nums[i];
            }
            if (smallestEle > nums[i]) {
                smallestEle = nums[i];
                smallestEleIndex = i;
            }
        }
        if (smallestEleIndex < largestEleIndex) {
            minSwaps += (n - 1 - largestEleIndex) + (smallestEleIndex);
            return minSwaps;
        }

        while (largestEleIndex < (n - 1)) {
            int temp = nums[largestEleIndex];
            nums[largestEleIndex] = nums[largestEleIndex + 1];
            nums[largestEleIndex + 1] = temp;
            largestEleIndex++;
            minSwaps++;
        }

        smallestEle = nums[0];
        smallestEleIndex = 0;
        for (int i = 0; i < n; i++) {
            if (smallestEle > nums[i]) {
                smallestEle = nums[i];
                smallestEleIndex = i;
            }
        }
        minSwaps += smallestEleIndex;
        return minSwaps;
    }

    public static void main(String[] args) {
        MinimumAdjacentSwapsToMakeValidArray minimumAdjacentSwapsToMakeValidArray = new MinimumAdjacentSwapsToMakeValidArray();
        System.out.println(minimumAdjacentSwapsToMakeValidArray.minimumSwaps(new int[] { 3, 4, 5, 5, 3, 1 }));
    }
}
