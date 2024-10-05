package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        var closestElements = new ArrayList<Integer>(k);
        int n = arr.length, left = 0, right = n - 1;
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = left; i <= right; i++) {
            closestElements.add(arr[i]);
        }

        return closestElements;
    }
}
