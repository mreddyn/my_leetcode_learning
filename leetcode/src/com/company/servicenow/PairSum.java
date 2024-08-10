package com.company.servicenow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PairSum {
    private List<List<Integer>> findPairs(int[] nums, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        int n = nums.length;
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int complement = k - nums[i];
            if (seen.contains(complement)) {
                List<Integer> tempList = new ArrayList<>(2);
                tempList.add(complement);
                tempList.add(nums[i]);
                resultList.add(tempList);
                seen.remove(complement);
            } else {
                seen.add(nums[i]);
            }

        }
        return resultList;
    }

    public static void main(String[] args) {
        PairSum pairSum = new PairSum();
        System.out.println(pairSum.findPairs(new int[] { 1, 2, 1, 2, 3, 1, 2 }, 3));
    }
}
