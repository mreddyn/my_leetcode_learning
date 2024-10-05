package com.company.facebook.medium;

public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            // missing numbers between nums[i-1] and nums[i]
            // if k is among missing numbers then return nums[i-1]+k
            // else decrement k by number of missing numbers
            int missed_in_gap = nums[i] - nums[i - 1] - 1;
            if (missed_in_gap >= k) {
                return nums[i - 1] + k;
            }
            k -= missed_in_gap;
        }

        // if no number is missing in nums, then missing element is out of bounds i.e,
        // nums[n-1]+k
        return nums[n - 1] + k;
    }

    public int missingElementApproachTwo(int[] nums, int k) {
        int n = nums.length, start = nums[0], left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int missed = (nums[mid] - start) - mid;
            if (missed >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left--;
        int skipped = (nums[left] - start) - left;
        return nums[left] + (k - skipped);
    }

    public static void main(String[] args) {
        MissingElementInSortedArray mArray = new MissingElementInSortedArray();
        System.out.println(mArray.missingElement(new int[] { 4, 7, 9, 10 }, 3));
    }
}
