package com.company.doordash;

import java.util.ArrayList;
import java.util.Collections;

public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        var jobProfile = new ArrayList<int[]>();
        int n = difficulty.length;

        jobProfile.add(new int[] { 0, 0 });
        for (int i = 0; i < n; i++) {
            jobProfile.add(new int[] { difficulty[i], profit[i] });
        }

        // sort by difficulty values in increasing order
        Collections.sort(jobProfile, (a, b) -> Integer.compare(a[0], b[0]));
        // pre-compute the maxProfit upto that index

        for (int i = 0; i < jobProfile.size() - 1; i++) {
            jobProfile.get(i + 1)[1] = Math.max(jobProfile.get(i)[1], jobProfile.get(i + 1)[1]);
        }

        int netProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            int ability = worker[i];

            // find the job with just smaller or equal difficulty than ability
            int left = 0;
            int right = jobProfile.size();
            int jobProfit = 0;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (jobProfile.get(mid)[0] <= ability) {
                    left = mid + 1;
                    jobProfit = Math.max(jobProfit, jobProfile.get(mid)[1]);
                } else {
                    right = mid;
                }

            }

            netProfit += jobProfit;
        }

        return netProfit;
    }
}
