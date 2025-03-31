package com.company.doordash;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaximumProfitJobScheduling {
    public int maxProfit(int start_time, int end_time, int[] d_starts, int[] d_ends, int[] d_pays) {
        int n = d_starts.length;
        var jobs = new ArrayList<Job>();

        // filter out any deliveries that don’t fully fit in your work window (i.e.,
        // ignore deliveries where the start is before your start_time or the end is
        // after your end_time).
        for (int i = 0; i < n; i++) {
            if (d_starts[i] >= start_time && d_ends[i] <= end_time) {
                jobs.add(new Job(d_starts[i], d_ends[i], d_pays[i]));
            }
        }

        // sort the jobs by start time
        jobs.sort((a, b) -> a.start - b.start);

        int maxProfit = 0;
        var minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int m = jobs.size();

        for (int i = 0; i < m; i++) {
            int start = jobs.get(i).start;
            int end = jobs.get(i).end;
            int pay = jobs.get(i).pay;
            // remove all jobs that end before the current job starts
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= start) {
                var finished = minHeap.poll();
                maxProfit = Math.max(maxProfit, finished[1]);
            }

            // compute the profit for the current job with the best previous job
            pay += maxProfit;

            // add the current job to the heap
            minHeap.offer(new int[] { end, pay });
        }

        // after the loop, we need to check if there are any jobs left in the heap
        while (!minHeap.isEmpty()) {
            var finished = minHeap.poll();
            maxProfit = Math.max(maxProfit, finished[1]);
        }
        return maxProfit;
    }

    class Job {
        int start;
        int end;
        int pay;

        public Job(int start, int end, int pay) {
            this.start = start;
            this.end = end;
            this.pay = pay;
        }
    }
}
