package com.leetcode;

public class TimeNeededToRearrangeABinaryString {
    public int secondsToRemoveOccurrences(String s) {
        /*
         * We need to get all ones to front of the array.
         */
        int n = s.length(), timeNeeded = 0, onesCount = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (ch[i] == '1') {
                onesCount++;
            }
        }
        if (onesCount == 0) {
            return 0;
        }
        int onesIndex = 0;
        while (onesCount > 0) {
            if (ch[onesIndex] == '1') {
                onesCount--;
                onesIndex++;
            } else {
                for (int j = onesIndex; j < n - 1; j++) {
                    if (ch[j] == '0' && ch[j + 1] == '1') {
                        ch[j] = '1';
                        ch[j + 1] = '0';
                        j++;
                    }
                }
                timeNeeded++;
            }
        }

        return timeNeeded;
    }
}
