package com.company.servicenow;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    private boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] intervalOne, int[] intervalTwo) {
                return intervalOne[0] - intervalTwo[0];
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] < intervals[i][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();
        System.out.println(meetingRooms.canAttendMeetings(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
    }
}
