package com.company.microsoft.leetcode.medium;

public class LargestTimeForGivenDigits {
    private int max_time = -1;

    public String largestTimeFromDigits(int[] arr) {
        int n = arr.length;
        for (int i1 = 0; i1 < n; i1++) {
            for (int i2 = 0; i2 < n; i2++) {
                for (int i3 = 0; i3 < n; i3++) {
                    // skip duplicate elements
                    if (i1 == i2 || i2 == i3 || i3 == i1) {
                        continue;
                    }

                    int i4 = 6 - i1 - i2 - i3;
                    int[] perm = { arr[i1], arr[i2], arr[i3], arr[i4] };
                    // check if it is a valid permutation
                    validatePermutation(perm);
                }
            }
        }

        if (this.max_time == -1) {
            return "";
        } else {
            return String.format("%02d:%02d", max_time / 60, max_time % 60);
        }
    }

    private void validatePermutation(int[] perm) {
        int hour = perm[0] * 10 + perm[1];
        int minute = perm[2] * 10 + perm[3];
        if (hour < 24 && minute < 60) {
            this.max_time = Math.max(this.max_time, hour * 60 + minute);
        }
    }
}
