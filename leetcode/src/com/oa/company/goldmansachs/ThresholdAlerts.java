package com.oa.company.goldmansachs;

public class ThresholdAlerts {
    public int numberOfAlerts(int precedingMinutes, int alertThreshold, int[] numCalls) {
        int n = numCalls.length;
        int totalAlerts = 0;
        // we will slide the window of size precedingMinutes and check if the average of
        // the window is greater than alertThreshold
        // if it is greater than alertThreshold, we will increment the totalAlerts
        int sum = 0;
        for (int i = 0; i < precedingMinutes; i++) {
            sum += numCalls[i];
        }

        for (int i = precedingMinutes; i < n; i++) {
            if ((sum / (double) precedingMinutes) > alertThreshold) {
                totalAlerts++;
            }
            sum += numCalls[i] - numCalls[i - precedingMinutes];
        }

        return totalAlerts;
    }

    public static void main(String[] args) {
        ThresholdAlerts obj = new ThresholdAlerts();
        int precedingMinutes = 3;
        int alertThreshold = 5;
        int[] numCalls = { 0, 11, 10, 10, 7 };
        System.out.println(obj.numberOfAlerts(precedingMinutes, alertThreshold, numCalls)); // 1
    }
}
