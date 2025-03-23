package com.oa.company.goldmansachs;

import java.util.Map;

public class PreprocessDates {
    public String[] preprocessDate(String[] dates) {
        /*
         * Convert the date string "Day Month Year" to the date string "YYYY-MM-DD" in
         * the format "4 digit year - 2 digit month - 2 digit day".
         */
        int n = dates.length;
        var res = new String[n];

        var monthMap = Map.ofEntries(Map.entry("Jan", "01"), Map.entry("Feb", "02"), Map.entry("Mar", "03"),
                Map.entry("Apr", "04"), Map.entry("May", "05"), Map.entry("Jun", "06"), Map.entry("Jul", "07"),
                Map.entry("Aug", "08"), Map.entry("Sep", "09"), Map.entry("Oct", "10"), Map.entry("Nov", "11"),
                Map.entry("Dec", "12"));

        for (int i = 0; i < n; i++) {
            var date = dates[i].split(" ");
            var day = date[0];
            var month = date[1];
            var year = date[2];

            if (day.length() == 3) {
                day = "0" + day.substring(0, 1);
            } else {
                day = day.substring(0, 2);
            }

            res[i] = year + "-" + monthMap.get(month) + "-" + day;
        }

        return res;
    }

    public static void main(String[] args) {
        PreprocessDates obj = new PreprocessDates();
        String[] dates = { "20th Oct 2052", "6th Jun 1933", "26th May 1960" };
        String[] res = obj.preprocessDate(dates);
        for (String date : res) {
            System.out.println(date);
        }
    }
}
