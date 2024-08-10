package com.leetcode_daily_challenge;

import java.util.PriorityQueue;

public class KthSmallestPrimeFaction {
    private int[] kthSmallestPrimeFaction(int[] arr, int k) {
        int[] answer = new int[2];
        int n = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // push the fractions formed by dividing each element to largest element in
        // array
        for (int i = 0; i < n; i++) {
            pq.offer(new double[] { -1.0 * arr[i] / arr[n - 1], i, n - 1 });
        }

        while (--k > 0) {
            double[] cur = pq.poll();
            int numeratorIndex = (int) cur[1];
            // take the next greatest element for denominator
            int denominatorIndex = (int) cur[2] - 1;
            if (denominatorIndex > numeratorIndex) {
                pq.offer(new double[] { -1.0 * arr[numeratorIndex] / arr[denominatorIndex], numeratorIndex,
                        denominatorIndex });
            }
        }
        double[] result = pq.poll();
        answer[0] = arr[(int) result[1]];
        answer[1] = arr[(int) result[2]];
        return answer;
    }

    public static void main(String[] args) {
        KthSmallestPrimeFaction kFaction = new KthSmallestPrimeFaction();
        kFaction.kthSmallestPrimeFaction(new int[] { 1, 2, 3, 5 }, 2);
    }
}
