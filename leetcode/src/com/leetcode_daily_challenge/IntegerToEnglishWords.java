package com.leetcode_daily_challenge;

public class IntegerToEnglishWords {
    private String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    private String[] thousands = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder result = new StringBuilder();
        int groupIndex = 0;

        // process the number in chunks of 1000
        while (num > 0) {
            // process the last three digits
            if (num % 1000 != 0) {
                StringBuilder groupResult = new StringBuilder();
                int part = num % 1000;

                // handle hundreds
                if (part >= 100) {
                    groupResult.append(ones[part / 100]).append(" Hundred ");
                    part %= 100;
                }

                // handle tens and units
                if (part >= 20) {
                    groupResult.append(tens[part / 10]).append(" ");
                    part %= 10;
                }

                // handle units
                if (part > 0) {
                    groupResult.append(ones[part]).append(" ");
                }

                // append thousands, millions, and billions
                groupResult.append(thousands[groupIndex]).append(" ");
                // insert the groupResult at the beginning of the final result
                result.insert(0, groupResult);
            }
            // move to the next chunk
            num /= 1000;
            groupIndex++;
        }

        return result.toString().trim();
    }
}
