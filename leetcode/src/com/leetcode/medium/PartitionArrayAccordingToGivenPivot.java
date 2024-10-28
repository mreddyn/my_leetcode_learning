package com.leetcode.medium;

import java.util.Arrays;

public class PartitionArrayAccordingToGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length, writeIndex = 0, pivotFreq = 0;
        var res = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                res[writeIndex++] = nums[i];
            } else if (nums[i] == pivot) {
                pivotFreq++;
            }
        }

        for (int i = 0; i < pivotFreq; i++) {
            res[writeIndex++] = pivot;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                res[writeIndex++] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionArrayAccordingToGivenPivot pivot = new PartitionArrayAccordingToGivenPivot();
        System.out.println(Arrays.toString(pivot.pivotArray(new int[] { 9, 12, 5, 10, 14, 3, 10 }, 10)));
    }
}
