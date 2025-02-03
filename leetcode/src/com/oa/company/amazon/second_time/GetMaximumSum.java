package com.oa.company.amazon.second_time;

import java.util.Arrays;
import java.util.PriorityQueue;

public class GetMaximumSum {
    public long getMaximumSum(int[][] data, int[] factor, int x) {
        int rows = data.length;

        if (Arrays.stream(factor).sum() < x) {
            return -1;
        }

        long sum = 0;
        int MOD = 1000000007;

        var minHeap = new PriorityQueue<Integer>();
        for (int row = 0; row < rows; row++) {
            var rowData = data[row];
            Arrays.sort(rowData);
            // pick factor[i] elements from each row
            int index = rowData.length - 1;
            while (factor[row]-- > 0) {
                minHeap.add(rowData[index--]);

                if (minHeap.size() > x) {
                    minHeap.poll();
                }
            }
        }

        System.out.println(minHeap);
        while (x > 0) {
            sum = (sum + minHeap.poll()) % MOD;
            x--;
        }

        return sum;
    }

    public static void main(String[] args) {
        GetMaximumSum obj = new GetMaximumSum();
        int[][] data = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[] factor = { 1, 2, 1 };
        int x = 2;
        System.out.println(obj.getMaximumSum(data, factor, x));
    }
}