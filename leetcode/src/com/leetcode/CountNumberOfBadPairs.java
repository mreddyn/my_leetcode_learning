package com.leetcode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {
    public long countBadPairs(int[] nums) {
        /*
         * for i < j, to calculate j-i != nums[j] - nums[i]
         * we can convert into nums[i] - i != nums[j] - j (bad pairs)
         * In order to calculate bad pairs we can use the formula Total pairs Count =
         * badPairsCount+goodPairsCount
         * goodPairsCount = nums[i] - i == nums[j] - j
         * badPairsCount = nums[i] - i != nums[j] - j
         * Total Pairs Count = (n * (n-1)) /2, where n = size of the array
         */
        long goodPairsCount = 0;
        int n = nums.length;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            long count = map.getOrDefault(diff, 0L);
            goodPairsCount += count;
            map.put(diff, count + 1);
        }

        long badPairsCount = 0, totalPairsCount = (n * (n - 1)) / 2;
        badPairsCount = totalPairsCount - goodPairsCount;
        System.out.println(totalPairsCount + " " + goodPairsCount + " " + badPairsCount);
        return badPairsCount;
    }

    public long countBadPairsApproachTwo(int[] nums) {
        int n = nums.length;
        Map<Integer, Long> map = new HashMap<>();
        long badPairsCount = 0;
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            long goodPairsCount = map.getOrDefault(diff, 0L);
            badPairsCount += i - goodPairsCount; // until i there are i pairs we can form using i values in nums
            map.put(diff, goodPairsCount + 1);
        }
        return badPairsCount;
    }

    public static void main(String[] args) {
        CountNumberOfBadPairs countNumberOfBadPairs = new CountNumberOfBadPairs();
        System.out.println(countNumberOfBadPairs.countBadPairs(new int[] { 4, 1, 3, 3 }));
    }
}
