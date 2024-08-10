package com.leetcode_daily_challenge;

import java.util.Arrays;

public class NumberOfFlowersInFullBloom {
    private int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] result = new int[people.length];
        int[] flowersBloomStart = new int[flowers.length];
        int[] flowersBloomEnd = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            flowersBloomStart[i] = flowers[i][0];
            flowersBloomEnd[i] = flowers[i][1];
        }
        Arrays.sort(flowersBloomStart);
        Arrays.sort(flowersBloomEnd);
        for (int i = 0; i < people.length; i++) {
            int start = helper(flowersBloomStart, people[i] + 1);
            int end = helper(flowersBloomEnd, people[i]);
            System.out.println(people[i] + " " + start + " " + end);
            result[i] = start - end;
        }
        return result;
    }

    private int helper(int[] nums, int target) {
        int result = nums.length;
        int left, right;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfFlowersInFullBloom numberOfFlowersInFullBloom = new NumberOfFlowersInFullBloom();
        int[][] flowers = { { 1, 6 }, { 3, 7 }, { 9, 12 }, { 4, 13 } };
        int[] people = { 2, 3, 7, 11 };
        int[] result = numberOfFlowersInFullBloom.fullBloomFlowers(flowers, people);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
