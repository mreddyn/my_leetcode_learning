package com.oa.company.uber;

public class Question2 {
    private static String solution(String[] schedule, String time) {
        int n;
        n = schedule.length;
        for (int i = 0; i < n; i++) {
            int res_a = timeToDecimal(time);
            int res_b = timeToDecimal(schedule[i]);
            if (res_a == res_b) {
                return "00:00";
            } else if (res_a < res_b) {
                return decimalToTime(res_b - res_a);
            } else {
                continue;
            }
        }
        return "-1";
    }

    private static int timeToDecimal(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        System.out.println("time : " + time);
        System.out.println("hours : " + hours);
        System.out.println("minutes : " + minutes);
        int totalMinutes = (hours * 60) + minutes;
        return totalMinutes;
    }

    private static String decimalToTime(int minutes) {
        int hours = minutes / 60;
        minutes = minutes - (hours * 60);
        return (hours > 9) ? ("" + hours + ":" + minutes) : ("0" + hours + ":" + minutes);
    }

    public static void main(String[] args) {
        String[] schedule = { "12:20", "14:00", "19:55" };
        String time = "19:30";
        System.out.println(solution(schedule, time));
    }
}
