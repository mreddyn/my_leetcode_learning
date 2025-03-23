package com.oa.company.goldmansachs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ProcessScheduler {
    public int getMinCores(int[] start, int[] end) {
        if (start == null || end == null || start.length == 0 || end.length == 0) {
            return 0;
        }

        // this problem is similar to the meeting room problem
        // we need to find the minimum number of meeting rooms required
        // to schedule all the processes
        // we can sort the start and end times and then iterate through them
        Arrays.sort(start);
        Arrays.sort(end);

        int n = start.length;
        var minHeap = new PriorityQueue<Integer>(); // to store the end times of the processes

        // add the first process to the minHeap
        minHeap.add(end[0]);

        // now we iterate through the rest of the processes
        for (int i = 1; i < n; i++) {
            // if the start time of the current process is greater than the end time of the
            // process
            // that is going to finish first, we can reuse the core
            if (start[i] > minHeap.peek()) {
                minHeap.poll();
            }

            // add the end time of the current process to the minHeap
            minHeap.add(end[i]);
        }

        return minHeap.size();
    }

    public static void main(String[] args) {
        ProcessScheduler obj = new ProcessScheduler();
        int[] start = { 1, 2, 3 };
        int[] end = { 3, 3, 5 };
        System.out.println(obj.getMinCores(start, end)); // 2
    }
}
