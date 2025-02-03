package com.oa.company.amazon.second_time;

import java.util.Arrays;

public class GetMaxStability {
    public int getMaxStability(int[] reliability, int[] availability) {
        // write your code here
        int n = availability.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = reliability[i];
            arr[i][1] = availability[i];
        }
        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(b[1], a[1]);
        });
        int res = 0;
        int sum = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i][0];
            min = arr[i][1];
            res = Math.max(res, sum * min);
        }
        return res;
    }
}
