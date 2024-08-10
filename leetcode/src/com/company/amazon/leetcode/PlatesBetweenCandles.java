package com.company.amazon.leetcode;

import java.util.Arrays;

public class PlatesBetweenCandles {
    private int[] platesBetweenCandles(String s, int[][] queries) {
        int queriesSize = queries.length, n = s.length(), queryIndex = 0;
        int[] plates = new int[queriesSize];
        int[] nearestLeftCandle = new int[n];
        int[] nearestRightCandle = new int[n];
        int[] candleCount = new int[n];
        int candle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestLeftCandle[i] = candle;
        }

        candle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestRightCandle[i] = candle;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                count++;
            }
            candleCount[i] = count;
        }

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int rightMostCandle = nearestRightCandle[left];
            int leftMostCandle = nearestLeftCandle[right];
            if (rightMostCandle == -1 || leftMostCandle == -1) {
                plates[queryIndex++] = 0;
            } else {
                int distance = leftMostCandle - rightMostCandle;
                if (distance > 1) {
                    plates[queryIndex++] = leftMostCandle - rightMostCandle + 1
                            - (candleCount[leftMostCandle] - candleCount[rightMostCandle] + 1);
                } else {
                    plates[queryIndex++] = 0;
                }
            }
        }
        return plates;
    }

    public static void main(String[] args) {
        PlatesBetweenCandles platesBetweenCandles = new PlatesBetweenCandles();
        String s = "**|**|***|";
        int[][] queries = { { 2, 4 }, { 5, 10 } };
        int[] result = platesBetweenCandles.platesBetweenCandles(s, queries);
        System.out.println(Arrays.toString(result));
    }
}
