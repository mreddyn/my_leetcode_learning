package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    private List<Integer> findAllDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] < 0) {
                duplicates.add(val + 1);
            }
            nums[val] = -nums[val];
        }

        return duplicates;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray findAllDuplicatesInAnArray = new FindAllDuplicatesInAnArray();
        System.out.println(findAllDuplicatesInAnArray.findAllDuplicates(new int[] { 1, 1, 2 }));
    }
}
