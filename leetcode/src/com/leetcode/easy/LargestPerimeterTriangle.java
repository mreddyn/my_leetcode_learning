package com.leetcode.easy;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        int largestTrianglePerimeter = 0, n = nums.length;
        Arrays.sort(nums);
        int index = 0;
        while (index < n - 2 && index + 1 < n - 1 && index + 2 < n) {
            int a = nums[index], b = nums[index + 1], c = nums[index + 2];
            if (isTriangle(a, b, c)) {
                largestTrianglePerimeter = Math.max(largestTrianglePerimeter, a + b + c);
            }
            index++;
        }

        return largestTrianglePerimeter;
    }

    private boolean isTriangle(int a, int b, int c) {
        if (a + b > c && b + c > a && c + a > b) {
            return true;
        }
        return false;
    }

    public int largestPerimeterApproachTwo(int[] nums) {
        /*
         * To form a triangle with largest area we will sort the array and try to form a
         * triangle with largest three numbers.
         * if a >= b >= c then a < b+c to form a triangle
         */
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
