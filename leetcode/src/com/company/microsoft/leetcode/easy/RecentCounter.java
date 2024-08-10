package com.company.microsoft.leetcode.easy;

import java.util.LinkedList;

public class RecentCounter {
    private LinkedList<Integer> slidingWindow;

    public RecentCounter() {
        this.slidingWindow = new LinkedList<>();
    }

    public int ping(int t) {
        // Add the current time
        this.slidingWindow.addLast(t);

        // remove outdated pings which are less than (t-3000)
        while (this.slidingWindow.getFirst() < (t - 3000)) {
            this.slidingWindow.removeFirst();
        }

        return this.slidingWindow.size();
    }
}
