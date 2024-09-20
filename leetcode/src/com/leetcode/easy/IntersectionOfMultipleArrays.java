package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntersectionOfMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        /*
         * To find intersection of multiple arrays where each array consists of only
         * distinct elements we can insert all the elements from nums into
         * countMap[1001].
         * Then we will check if a num from countMap[] has freq at least n times.
         */
        var resultList = new ArrayList<Integer>();
        var countMap = new int[1001];
        int n = nums.length;
        for (int[] num : nums) {
            for (int i = 0; i < num.length; i++) {
                countMap[num[i]]++;
            }
        }

        for (int i = 0; i < nums[0].length; i++) {
            int num = nums[0][i];
            if (countMap[num] >= n) {
                resultList.add(num);
            }
        }

        // sort the resultList when returning.
        Collections.sort(resultList);
        return resultList;
    }
}
