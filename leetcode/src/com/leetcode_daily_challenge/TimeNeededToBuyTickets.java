package com.leetcode_daily_challenge;

public class TimeNeededToBuyTickets {
    private int timeRequiredToBuy(int[] tickets, int k) {
        int timeTaken = 0, totalTickets = tickets.length;
        for (int i = 0; i < totalTickets; i++) {
            if (i <= k) {
                timeTaken += Math.min(tickets[i], tickets[k]);
            } else {
                timeTaken += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        return timeTaken;
    }

    public static void main(String[] args) {
        TimeNeededToBuyTickets timeNeededToBuyTickets = new TimeNeededToBuyTickets();
        System.out.println(timeNeededToBuyTickets.timeRequiredToBuy(new int[] { 84, 49, 5, 24, 70, 77, 87, 8 }, 3));
    }
}
