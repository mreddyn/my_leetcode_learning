package com.company.amazon.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // maintain two maps to keep track the occurrences of two given arrays
        var nums1Count = new int[2001];
        var nums2Count = new int[2001];
        for (int num : nums1) {
            nums1Count[num + 1000]++;
        }

        for (int num : nums2) {
            nums2Count[num + 1000]++;
        }

        var nums1DistinctElementsList = new ArrayList<Integer>();
        for (int num : nums1) {
            // search for an element from nums1 in nums2, if it exists ignore.
            if (nums1Count[num + 1000] == 0) {
                // if the element is already added, then continue
                continue;
            }
            if (nums2Count[num + 1000] > 0) {
                // if the nums1 element is occurring in nums2 then ignore it.
                continue;
            }
            // otherwise mark the element as visited and add it to distinct elements list.
            nums1Count[num + 1000] = 0;
            nums1DistinctElementsList.add(num);
        }

        var nums2DistinctElementsList = new ArrayList<Integer>();
        for (int num : nums2) {
            if (nums2Count[num + 1000] == 0) {
                continue;
            }
            if (nums1Count[num + 1000] > 0) {
                continue;
            }
            nums2Count[num + 1000] = 0;
            nums2DistinctElementsList.add(num);
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(nums1DistinctElementsList);
        result.add(nums2DistinctElementsList);

        return result;
    }
}
