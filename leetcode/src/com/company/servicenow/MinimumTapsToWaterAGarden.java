package com.company.servicenow;

public class MinimumTapsToWaterAGarden {
    private int minTaps(int n, int[] ranges) {
        int totalTaps = ranges.length;
        int[] startEnd = new int[n + 1];
        for (int i = 0; i < totalTaps; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            startEnd[start] = Math.max(startEnd[start], end);
        }

        for (int i = 0; i < n + 1; i++) {
            startEnd[i] = Math.max(0, startEnd[i] - i);
        }
        int minTapCount, curEnd, curFar;
        minTapCount = 0;
        curEnd = 0;
        curFar = 0;
        for (int i = 0; i < n; i++) {
            curFar = Math.max(curFar, startEnd[i] + i);
            if (i == curEnd) {
                minTapCount++;
                curEnd = curFar;
            }
        }
        if(curFar < n){
            return -1;
        }
        System.out.println(curEnd + " " + curFar);

        return minTapCount;
    }

    public static void main(String[] args) {
        MinimumTapsToWaterAGarden minimumTapsToWaterAGarden = new MinimumTapsToWaterAGarden();
        System.out.println(minimumTapsToWaterAGarden.minTaps(5, new int[] { 3, 4, 1, 1, 0, 0 }));
        System.out.println(minimumTapsToWaterAGarden.minTaps(3, new int[] { 0, 0, 0, 0 }));
    }

}
