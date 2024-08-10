package com.leetcode_daily_challenge;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        int moves = 0, totalSeats = seats.length;
        Arrays.sort(seats);
        Arrays.sort(students);
        // find the nearest seat for the student
        // seats = [4,1,5,9], students = [1,3,2,6] after sorting becomes
        // seats = [1,4,5,9], students = [1,2,3,6]
        for (int i = 0; i < totalSeats; i++) {
            moves += Math.abs(students[i] - seats[i]);
        }
        return moves;
    }
}
