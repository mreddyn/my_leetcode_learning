package com.oa.company.microsoft.hiringevent;

import java.util.HashMap;

public class MaximizeSpaceAfterFreeingShelves {
    public int maximizeTypesAfterFreeingShelves(int[] nums, int r) {
        /*
         * A storeroom is used to organize items stored in it on N shelves. Shelves are
         * numbered from 0 to N-1. The K-th shelf is dedicated to items of only one
         * type, denoted by a positive integer nums[K].
         * 
         * Recently it was decided that it is necessary to free R consecutive shelves.
         * Shelves cannot be reordered. What is the maximum number of types of items
         * that can still be stored in the storeroom after freeing R consecutive
         * shelves?
         * 
         * Given:
         * 
         * an array nums of N integers representing types of items stored on storeroom
         * shelves.
         * an integer r representing the number of consecutive shelves to be freed.
         * Returns the maximum number of different types of items that can be stored in
         * the storeroom after freeing r consecutive shelves.
         */

        int n = nums.length;
        if (r == n) {
            // all shelves are freed
            return 0;
        }
        var map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // slide the window of size r from left to right and keep track of the maximum
        // number of types of items that can still be stored in the storeroom
        int res = 0;
        for (int i = 0; i < r; i++) {
            if (map.get(nums[i]) == 1) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], map.get(nums[i]) - 1);
            }
        }
        res = map.size();

        for (int i = r; i < n; i++) {
            if (map.get(nums[i - r]) == null) {
                map.put(nums[i - r], 1);
            } else {
                map.put(nums[i - r], map.get(nums[i - r]) + 1);
            }

            if (map.get(nums[i]) == 1) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], map.get(nums[i]) - 1);
            }

            res = Math.max(res, map.size());
        }

        return res;
    }

    public static void main(String[] args) {
        MaximizeSpaceAfterFreeingShelves obj = new MaximizeSpaceAfterFreeingShelves();
        System.out.println(obj.maximizeTypesAfterFreeingShelves(new int[] { 2, 1, 2, 3, 2, 3, 2 }, 3));
        System.out.println(obj.maximizeTypesAfterFreeingShelves(new int[] { 20, 10, 10, 10, 30, 20 }, 3));
        System.out.println(obj.maximizeTypesAfterFreeingShelves(new int[] { 1, 100000, 1 }, 3));
        System.out.println(obj.maximizeTypesAfterFreeingShelves(new int[] { 2, 3, 1, 1, 2 }, 2));
    }
}
