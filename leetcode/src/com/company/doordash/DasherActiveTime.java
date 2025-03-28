package com.company.doordash;

import java.util.ArrayList;
import java.util.List;

public class DasherActiveTime {
    public int getActiveTimes(List<String> activity) {
        // I will maintain two lists, one for pickup and one for dropoff
        // I will iterate through the activity list and add the time to the respective
        // list
        // Now it is similar to the merge interval problem
        // I will sort the two lists and then iterate through them to find the active
        // time

        List<Integer> pickup = new ArrayList<>();
        List<Integer> dropoff = new ArrayList<>();
        for (String act : activity) {
            var t = act.split(" ");
            if (t[1].equals("pickup")) {
                pickup.add(getMinutes(t[0]));
            } else {
                dropoff.add(getMinutes(t[0]));
            }
        }

        var intervals = new ArrayList<int[]>();
        int n = pickup.size();

        for (int i = 0; i < n; i++) {
            intervals.add(new int[] { pickup.get(i), dropoff.get(i) });
        }

        // sort the intervals by start time
        intervals.sort((a, b) -> a[0] - b[0]);

        int activeTime = 0;
        int start = intervals.get(0)[0];
        int end = intervals.get(0)[1];

        for (int i = 1; i < n; i++) {
            if (intervals.get(i)[0] <= end) {
                end = Math.max(end, intervals.get(i)[1]);
            } else {
                activeTime += end - start;
                start = intervals.get(i)[0];
                end = intervals.get(i)[1];
            }
        }

        activeTime += end - start;

        return activeTime;
    }

    private int getMinutes(String time) {
        var t = time.split(":");
        var hours = Integer.parseInt(t[0]);
        var minutes = Integer.parseInt(t[1].substring(0, t[1].length() - 2));

        if (time.endsWith("pm") && hours != 12) {
            hours += 12;
        }

        return hours * 60 + minutes;
    }

    public static void main(String[] args) {
        DasherActiveTime obj = new DasherActiveTime();
        List<String> activity = new ArrayList<>();
        activity.add("8:30am pickup");
        activity.add("9:10am dropoff");
        activity.add("10:20am pickup");
        activity.add("12:15pm pickup");
        activity.add("12:45pm dropoff");
        activity.add("2:25pm dropoff");

        System.out.println(obj.getActiveTimes(activity));
    }
}
