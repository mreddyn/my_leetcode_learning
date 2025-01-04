package com.oa.company.amazon.second_time;

public class MaximumMaximaCount {
    /**
     * Finds the maximum MaximumCount among all categories in the given string.
     *
     * @param categories The string representing categories of items purchased.
     * @return The highest MaximumCount value among all categories.
     */
    public static int findMaximumMaximumCount(String categories) {
        // Array to store frequency of each character ('a' to 'z')
        int[] freq = new int[26];

        // Array to store MaximumCount for each character
        int[] maxCount = new int[26];

        // Variable to keep track of the current maximum frequency
        int maxFreq = 0;

        // Iterate through each character in the string
        for (int i = 0; i < categories.length(); i++) {
            char currentChar = categories.charAt(i);
            int idx = currentChar - 'a'; // Map 'a'-'z' to 0-25

            // Update the frequency of the current character
            freq[idx]++;

            // Update the current maximum frequency if necessary
            if (freq[idx] > maxFreq) {
                maxFreq = freq[idx];
            }

            // Iterate through all characters to find those with freq == maxFreq
            for (int j = 0; j < 26; j++) {
                if (freq[j] == maxFreq) {
                    maxCount[j]++;
                }
            }
        }

        // Find the maximum value in maxCount array
        int result = 0;
        for (int count : maxCount) {
            if (count > result) {
                result = count;
            }
        }

        return result;
    }

    // Optional: Main method for testing purposes
    public static void main(String[] args) {
        // Example 1
        String categories1 = "bccaaacb";
        int result1 = findMaximumMaximumCount(categories1);
        System.out.println("Input: " + categories1);
        System.out.println("Output: " + result1); // Expected Output: 6

        // Example 2
        String categories2 = "zzzz";
        int result2 = findMaximumMaximumCount(categories2);
        System.out.println("Input: " + categories2);
        System.out.println("Output: " + result2); // Expected Output: 4

        // Additional Test Case
        String categories3 = "abcabcabc";
        int result3 = findMaximumMaximumCount(categories3);
        System.out.println("Input: " + categories3);
        System.out.println("Output: " + result3); // Expected Output: 3
    }
}
