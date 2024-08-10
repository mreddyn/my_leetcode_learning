package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointsThatIntersectWithCars {
    private int numberOfPoints(List<List<Integer>> nums) {
        int numPoints = 0, n = nums.size();
        int[] count = new int[102];
        for (int i = 0; i < n; i++) {
            int start = nums.get(i).get(0);
            int end = nums.get(i).get(1);
            count[start]++;
            count[end + 1]--;
        }
        for (int i = 1; i < 102; i++) {
            count[i] += count[i - 1];
            if (count[i] > 0) {
                numPoints++;
            }
        }
        return numPoints;
    }

    public static void main(String[] args) {
        PointsThatIntersectWithCars pIntersectWithCars = new PointsThatIntersectWithCars();
        List<Integer> num1 = Arrays.asList(3, 6);
        List<Integer> num2 = Arrays.asList(1, 5);
        List<Integer> num3 = Arrays.asList(4, 7);
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        pIntersectWithCars.numberOfPoints(nums);
    }
}
