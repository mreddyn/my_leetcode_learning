package com.oa.company.wayfair;

public class RouletteWheel {

    public static int solve(String[] history) {
        int totalScore = 0;

        // Continue until all strings are empty
        while (history[0].length() > 0) { // All strings have same length
            int turnMax = 0;

            // Process each row (string)
            for (int i = 0; i < history.length; i++) {
                String current = history[i];
                char maxChar = '0';
                int maxIndex = 0;

                // Find the maximum digit and its index in the current string
                for (int j = 0; j < current.length(); j++) {
                    if (current.charAt(j) > maxChar) {
                        maxChar = current.charAt(j);
                        maxIndex = j;
                    }
                }

                // Update the maximum for this turn if needed
                int digit = maxChar - '0';
                if (digit > turnMax) {
                    turnMax = digit;
                }

                // Remove the found maximum digit from the string
                // using substring to concatenate parts before and after maxIndex.
                history[i] = current.substring(0, maxIndex) + current.substring(maxIndex + 1);
            }

            // Add the highest digit found in this turn to the total score.
            totalScore += turnMax;
        }

        return totalScore;
    }

    public static void main(String[] args) {
        String[] history = { "712", "246", "365", "312" };
        System.out.println(solve(history)); // Expected output: 15
    }
}
