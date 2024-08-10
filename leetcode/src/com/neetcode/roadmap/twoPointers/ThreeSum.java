package com.neetcode.roadmap.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                int numOne = nums[i];
                int left = i + 1, right = n - 1;
                while (left < right) {
                    int numTwo = nums[left];
                    int numThree = nums[right];
                    int sum = numOne + numTwo + numThree;
                    if (sum == 0) {
                        resultList.add(Arrays.asList(numOne, numTwo, numThree));
                        // skip if you see same numbers
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return resultList;
    }
}
