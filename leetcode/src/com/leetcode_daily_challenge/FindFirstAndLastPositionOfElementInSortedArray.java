package com.leetcode_daily_challenge;

public class FindFirstAndLastPositionOfElementInSortedArray {
    private int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int left, right;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid != left && nums[mid - 1] == target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    private int findLast(int[] nums, int target) {
        int left, right;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid != right && nums[mid + 1] == target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int[] result = findFirstAndLastPositionOfElementInSortedArray.searchRange(nums, 8);
        System.out.println(result[0] + " " + result[1]);
    }
}
