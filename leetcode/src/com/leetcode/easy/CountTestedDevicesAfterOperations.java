package com.leetcode.easy;

public class CountTestedDevicesAfterOperations {
    public int countTestedDevices(int[] batteryPercentages) {
        /*
         * Since we only need to count the test devices (> 0) and decrement the
         * percentages to its right,
         * we will maintain a counter init with zero, we will decrement the percentage
         * counter times,
         * this indicates there are counter batteries tested before current percentage.
         * FInally whenever a percentage is greater than zero it is counted.
         */
        int testedDevicesCount = 0, n = batteryPercentages.length, decrementCount = 0;
        for (int i = 0; i < n; i++) {
            batteryPercentages[i] -= decrementCount;
            if (batteryPercentages[i] > 0) {
                testedDevicesCount++;
                decrementCount++;
            }
        }

        return testedDevicesCount;
    }

    public static void main(String[] args) {
        CountTestedDevicesAfterOperations cAfterOperations = new CountTestedDevicesAfterOperations();
        System.out.println(cAfterOperations.countTestedDevices(new int[] { 1, 1, 2, 1, 3 }));
    }
}
