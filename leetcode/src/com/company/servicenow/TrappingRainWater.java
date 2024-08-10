package com.company.servicenow;

public class TrappingRainWater {
    private int trap(int[] height) {
        int totalTrappedWater = 0;
        int n = height.length;
        if (n <= 2) {
            return totalTrappedWater;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        for (int i = n - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            int curMax = Math.min(leftMax[i], rightMax[i]);
            if (curMax <= height[i]) {
                continue;
            }
            totalTrappedWater += curMax - height[i];
        }

        return totalTrappedWater;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }
}
