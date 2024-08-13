package com.oa.company.amazon;

public class GetLongestMatch {
    public int getLongestMatch(String text, String regex) {
        // write your code here
        // Split the regex around the wildcard character

        // Split the regex around the wildcard character
        String[] parts = regex.split("\\*", -1);

        String firstPart = parts[0];
        String secondPart = parts[1];
        int maxLength = -1;

        // Start by finding the first occurrence of the first part
        for (int firstIndex = text.indexOf(firstPart); firstIndex != -1; firstIndex = text.indexOf(firstPart,
                firstIndex + 1)) {
            // Find every occurrence of the second part after the first part
            for (int secondIndex = text.indexOf(secondPart,
                    firstIndex + firstPart.length() - 1); secondIndex != -1; secondIndex = text.indexOf(secondPart,
                            secondIndex + 1)) {
                // Calculate the length from the start of the first part to the end of the
                // second part
                int length = secondIndex + secondPart.length() - firstIndex;
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;

    }

    public static void main(String[] args) {
        GetLongestMatch gLongestMatch = new GetLongestMatch();
        System.out.println(gLongestMatch.getLongestMatch("hackerrank", "ack*r"));
    }
}
