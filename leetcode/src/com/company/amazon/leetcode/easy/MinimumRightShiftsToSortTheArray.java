package com.company.amazon.leetcode.easy;

import java.util.List;

public class MinimumRightShiftsToSortTheArray {
    public int minimumRightShifts(List<Integer> nums) {
        int listSize = nums.size(), count = 0, pivot = 0;
        for (int i = 1; i < listSize; i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                pivot = i;
                count++;
            }
        }

        if (count == 0) {
            // the array is sorted, no need of right shifts
            return 0;
        }

        if (count > 1 || (nums.get(0) < nums.get(listSize - 1))) {
            // if the array is rotated then there should be only one pivot,
            // if there is more than one pivot then the array is zig zag and
            // can not be sorted by shifting
            return -1;
        }
        return listSize - pivot;

    }
}
