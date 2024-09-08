package com.leetcode.easy;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        /*
         * > Calculate the total sum of the array and divide it by 3. If the sum doesn't
         * get completely divided by 3, we can't partition the array;
         * else, we "might" be able to partition the array
         * 
         * --> After checking this condition, we can traverse the array, keeping track
         * of the sum of the elements of the array.
         * As soon as we encounter the sum to be equal to the previously calculated sum
         * (which we found out by dividing the total sum by 3), we made a partition,
         * hence decrement 3 to 2... and keep on doing this until the end of the array.
         * 
         * --> Now, finally check whether all 3 partitions have been successfully made
         * or not and return accordingly
         */
        int n = arr.length, totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        if (totalSum % 3 != 0) {
            return false;
        }

        int eachPartSum = totalSum / 3, partsCount = 0, curPartSum = 0;
        for (int i = 0; i < n; i++) {
            curPartSum += arr[i];
            if (curPartSum == eachPartSum) {
                partsCount++;
                curPartSum = 0;
                if (partsCount == 3) {
                    return true;
                }
            }
        }

        return false;
    }
}
