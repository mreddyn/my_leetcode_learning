package com.company.microsoft.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PanCakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        /*
         * TO sort an array by Pancake we need to follow these steps
         * 1. Get the largest number index and flip the prefix array until index so that
         * largest number
         * comes to front.
         * 2. Then we need to flip the whole array such that largest number moves to its
         * index (last place)
         */
        List<Integer> kValues = new ArrayList<>();
        int n = arr.length;
        for (int value_to_sort = n; value_to_sort > 0; value_to_sort--) {
            // Get the index of the value_to_sort
            int index = find(arr, value_to_sort);

            if (index == value_to_sort - 1) {
                // number already in correct position
                continue;
            }

            // check if the value_to_sort is already at zero index
            if (index != 0) {
                flip(arr, index + 1);
                kValues.add(index + 1);
            }

            // now that the value_to_sort number is at zero index, push it to bottom
            kValues.add(value_to_sort);
            flip(arr, value_to_sort);
        }
        return kValues;
    }

    private void flip(int[] arr, int k) {
        int temp, left = 0, right = k - 1;
        while (left < right) {
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }

    private int find(int[] arr, int target) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == target) {
                return index;
            }
        }
        return -1;
    }
}
