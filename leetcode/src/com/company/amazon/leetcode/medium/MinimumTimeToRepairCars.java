package com.company.amazon.leetcode.medium;

public class MinimumTimeToRepairCars {
    public long repairCars(int[] ranks, int cars) {
        /*
         * Because cars > 0,
         * left = 1.
         * 
         * Because mechanic A[i] can repair n cars in A[i] * n * n minutes.
         * right = A[0] * cars * cars.
         * 
         * Binary search the time taken to repair all the cars.
         * Assume we have mid minutes,
         * then the ith mechanic can repair sqrt(mid / A[i] cars,
         * and we round to floor integer here.
         * We calculate all the cur cars we can repair,
         * If cur < cars, not enough time, left = mid + 1
         * If cur >= cars, enough time, right = mid.
         */
        long left = 1, right = 1L * ranks[0] * cars * cars;
        while (left < right) {
            long mid = left + (right - left) / 2, curCars = 0;
            for (int rank : ranks) {
                curCars += (long) (Math.sqrt(1.0 * mid / rank));
            }
            if (curCars < cars) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
