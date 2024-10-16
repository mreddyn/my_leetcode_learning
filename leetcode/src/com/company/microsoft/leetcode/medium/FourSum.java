package com.company.microsoft.leetcode.medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        var seen = new HashSet<String>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            if (seen.add("" + nums[i] + nums[j] + nums[k] + nums[l])) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            }

                        }
                    }
                }
            }
        }

        return result;
    }

    public List<List<Integer>> fourSumApproachTwo(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // if we run out of numbers then return
        if (start == nums.length) {
            return res;
        }

        // there are k remaining values to add.
        // each of these numbers will be atleast target/k
        long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > average_value || nums[nums.length - 1] < average_value) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subSet : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subSet);
                }
            }
        }

        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length, low = start, high = n - 1;
        while (low < high) {
            int curSum = nums[low] + nums[high];
            if (curSum < target || (low > start && nums[low] == nums[low - 1])) {
                low++;
            } else if (curSum > target || (high < n - 1 && nums[high] == nums[high + 1])) {
                high--;
            } else {
                res.add(Arrays.asList(nums[low], nums[high]));
                low++;
                high--;
            }
        }

        return res;
    }
}
