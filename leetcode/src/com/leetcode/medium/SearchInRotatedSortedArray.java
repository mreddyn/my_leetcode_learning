package com.leetcode.medium;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        /*
         * Find the array where it is rotated and do binary search on two parts
         *
         */
        int n = nums.length;
        int left = 0, right = n;
        // find the pivot index (the smallest element in the array)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // binary search over elements on the pivot element's left
        int answer = binarySearch(nums, 0, left, target);
        if (answer != -1) {
            return answer;
        }

        // binary search over elements on the pivot elements's right
        answer = binarySearch(nums, left, n, target);

        return answer;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
