package com.company.microsoft.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsTwo {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;

        // sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        // use a min heap to track the minimum end time of merged intervals
        var heap = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));

        // start with first meeting end time
        heap.offer(intervals[0]);

        for (int i = 1; i < n; i++) {
            // get the meeting room that finishes earliest
            int[] prevMeeting = heap.poll();

            if (intervals[i][0] >= prevMeeting[1]) {
                // if the current meeting starts right after previous meeting ends.
                // then is no need of extra room
                prevMeeting[1] = intervals[i][1];
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // put the meeting room back.
            heap.offer(prevMeeting);
        }

        return heap.size();
    }
}
