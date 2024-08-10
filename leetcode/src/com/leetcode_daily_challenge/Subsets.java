package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    List<List<Integer>> resultList;

    private List<List<Integer>> subsets(int[] nums) {
        resultList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return resultList;
    }

    private void backtrack(int[] nums, int index, List<Integer> curList) {
        resultList.add(new ArrayList<>(curList));
        for (int i = index; i < nums.length; i++) {
            curList.add(nums[i]);
            backtrack(nums, i + 1, curList);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subsets(null);
    }
}
