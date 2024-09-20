package com.leetcode.medium;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        /*
         * Since we only have 1,001 stops, we can just figure out how many people get it
         * and out in each location.
         * 
         * Solution
         * Process all trips, adding passenger count to the start location, and removing
         * it from the end location. After processing all trips, a positive value for
         * the specific location tells that we are getting more passengers; negative -
         * more empty seats.
         * 
         * Finally, scan all stops and check if we ever exceed our vehicle capacity.
         */
        int n = trips.length;
        var stops = new int[1001];
        for (int i = 0; i < n; i++) {
            int passengers = trips[i][0];
            int origin = trips[i][1];
            int destination = trips[i][2];

            stops[origin] += passengers;
            stops[destination] -= passengers;
        }

        for (int i = 0; i < 1001 && capacity >= 0; i++) {
            capacity -= stops[i];
        }

        return capacity >= 0;
    }
}
