package com.leetcode_daily_challenge;

import java.util.PriorityQueue;

public class SeatReservationManager {
    class SeatManager {
        private PriorityQueue<Integer> availableSeats;
        private int marker;

        public SeatManager(int n) {
            availableSeats = new PriorityQueue<>();
            marker = 1;
        }

        public int reserve() {
            if (availableSeats.isEmpty()) {
                return marker++;
            } else {
                return availableSeats.poll();
            }
        }

        public void unreserve(int seatNumber) {
            availableSeats.offer(seatNumber);
        }
    }
}
