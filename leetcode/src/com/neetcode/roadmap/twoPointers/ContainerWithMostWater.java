package com.neetcode.roadmap.twoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxWater = 0, n = height.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int curWater = (right - left) * Math.min(leftHeight, rightHeight);
            if (leftHeight < rightHeight) {
                left++;
            } else if (leftHeight > rightHeight) {
                right--;
            } else {
                left++;
                right--;
            }
            maxWater = Math.max(curWater, maxWater);
        }

        return maxWater;
    }
}
