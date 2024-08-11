package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> rangesList = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return rangesList;
        }
        int start = nums[0], stop = nums[0];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                stop = nums[i + 1];
            } else {
                if (start == stop) {
                    rangesList.add("" + start);
                } else {
                    rangesList.add(start + "->" + stop);
                }
                start = nums[i + 1];
                stop = nums[i + 1];
            }
        }

        if (start == stop) {
            rangesList.add("" + start);
        } else {
            rangesList.add(start + "->" + stop);
        }

        return rangesList;
    }

    public static void main(String[] args) {
        SummaryRanges sRanges = new SummaryRanges();
        System.out.println(sRanges.summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 }));
    }
}
