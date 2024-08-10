package com.leetcode_daily_challenge;

public class NumberOfSeniorCitizens {
    public int countSeniors(String[] details) {
        int seniorCitizensCount = 0;
        for (String detail : details) {
            String ageStr = detail.substring(11, 13);
            int age = Integer.parseInt(ageStr);
            if (age > 60) {
                seniorCitizensCount++;
            }
        }

        return seniorCitizensCount;
    }
}
