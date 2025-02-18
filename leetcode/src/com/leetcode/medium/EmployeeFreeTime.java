package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTime {
    // Definition for an Interval.
    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        var intervals = new ArrayList<Interval>();
        for (var employeeIntervals : schedule) {
            intervals.addAll(employeeIntervals);
        }

        intervals.sort((a, b) -> a.start - b.start);
        var merged = new ArrayList<Interval>();
        int prevStart = intervals.get(0).start;
        int prevEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            var interval = intervals.get(i);
            if (interval.start <= prevEnd) {
                // overlapping intervals
                prevEnd = Math.max(prevEnd, interval.end);
            } else {
                // non-overlapping intervals
                merged.add(new Interval(prevStart, prevEnd));
                prevStart = interval.start;
                prevEnd = interval.end;
            }
        }
        merged.add(new Interval(prevStart, prevEnd));

        // now need to find the free time intervals
        int n = merged.size();
        prevStart = merged.get(0).start;
        prevEnd = merged.get(0).end;
        var freeTimeIntervals = new ArrayList<Interval>();
        for (int i = 1; i < n; i++) {
            var interval = merged.get(i);
            if (interval.start > prevEnd) {
                // free time interval
                // prevEnd to interval.start
                freeTimeIntervals.add(new Interval(prevEnd, interval.start));
            }
            prevStart = interval.start;
            prevEnd = interval.end;
        }
        return freeTimeIntervals;
    }
}
