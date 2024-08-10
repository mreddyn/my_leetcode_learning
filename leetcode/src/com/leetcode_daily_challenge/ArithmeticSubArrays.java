package com.leetcode_daily_challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArithmeticSubArrays {
    private List<Boolean> checkArithmeticSubArrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> result = new java.util.ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            int left = l[i];
            int right = r[i];
            int[] subArray = new int[right - left + 1];
            for (int j = left; j <= right; j++) {
                subArray[j - left] = nums[j];
            }
            Arrays.sort(subArray);
            int[] diff = new int[subArray.length - 1];
            for (int j = 0; j < subArray.length - 1; j++) {
                diff[j] = subArray[j + 1] - subArray[j];
            }
            boolean isArithmetic = true;
            for (int j = 1; j < diff.length; j++) {
                if (diff[j] != diff[j - 1]) {
                    isArithmetic = false;
                    break;
                }
            }
            result.add(isArithmetic);
        }
        return result;
    }

    private List<Boolean> checkArithmeticSubArraysApproachTwo(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> result = new java.util.ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            int left = l[i];
            int right = r[i];
            int[] subArray = new int[right - left + 1];
            for (int j = left; j <= right; j++) {
                subArray[j - left] = nums[j];
            }
            result.add(check(subArray));
        }
        return result;
    }

    private Boolean check(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            minElement = Math.min(minElement, arr[i]);
            maxElement = Math.max(maxElement, arr[i]);
            set.add(arr[i]);
        }

        if ((maxElement - minElement) % (arr.length - 1) != 0) {
            return false;
        }
        int diff = (maxElement - minElement) / (arr.length - 1);
        int curr = minElement + diff;
        while (curr < maxElement) {
            if (!set.contains(curr)) {
                return false;
            }
            curr += diff;
        }
        return true;
    }

    public static void main(String[] args) {
        ArithmeticSubArrays arithmeticSubArrays = new ArithmeticSubArrays();
        int[] nums = { 4, 6, 5, 9, 3, 7 };
        int[] l = { 0, 0, 2 };
        int[] r = { 2, 3, 5 };
        List<Boolean> result = arithmeticSubArrays.checkArithmeticSubArrays(nums, l, r);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        List<Boolean> resultTwo = arithmeticSubArrays.checkArithmeticSubArraysApproachTwo(nums, l, r);
        for (int i = 0; i < resultTwo.size(); i++) {
            System.out.print(resultTwo.get(i) + " ");
        }
    }
}
