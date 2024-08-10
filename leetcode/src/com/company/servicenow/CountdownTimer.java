package com.company.servicenow;

public class CountdownTimer {
    private static void printCountDown(String timeString) {
        int minutes, seconds;
        String[] tokens = timeString.split(":");
        minutes = Integer.parseInt(tokens[0]);
        seconds = Integer.parseInt(tokens[1]);
        while (minutes >= 0) {
            while (seconds >= 0) {
                System.out.println(String.format("%2d:%2d", minutes, seconds));
                seconds--;
                if (seconds < 0) {
                    seconds = 59;
                    minutes--;
                }
                if (minutes < 0) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        printCountDown("2:00");
    }
}
