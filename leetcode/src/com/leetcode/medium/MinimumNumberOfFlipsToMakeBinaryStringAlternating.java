package com.leetcode.medium;

public class MinimumNumberOfFlipsToMakeBinaryStringAlternating {
    public int minFlips(String s) {
        /*
         * For the 1st operation, we can simply do s += s to append the whole string to
         * the end.
         * then we make two different string with the same length by 01 and 10
         * alternative. for example: s = 11100
         * do s += s: s = 1110011100
         * goal 1: s1= 1010101010
         * goal 2: s2= 0101010101
         * finally, use sliding window（size n）to compare s to both s1 and s2.
         * why we can double s to fullfil the first operation, let's look at the same
         * example s = 11100:`
         * double s: 1110011100
         * size n window: |11100|11100 ==> 1|11001|1100 ==> 11|10011|100 and so on, when
         * we move one step of the sliding window, it is the same to append 1 more
         * element from beginning.
         */
        int n = s.length(), minimumFlips = Integer.MAX_VALUE;

        // window
        int k = n;

        // instead of performing type 1 operation, we just append s to itself
        s = s + s;
        n += n;

        // alternating strings that start with 0 and 1
        var altStrBuilderOne = new StringBuilder(k);
        var altStrBuilderTwo = new StringBuilder(k);

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                altStrBuilderOne.append('0');
                altStrBuilderTwo.append('1');
            } else {
                altStrBuilderOne.append('1');
                altStrBuilderTwo.append('0');
            }
        }

        var altOne = altStrBuilderOne.toString();
        var altTwo = altStrBuilderTwo.toString();

        // minimum number of differences between s and altOne, altTwo
        int diffOne = 0, diffTwo = 0;

        for (int end = 0, start = 0; end < n; end++) {
            if (s.charAt(end) != altOne.charAt(end)) {
                diffOne++;
            }
            if (s.charAt(end) != altTwo.charAt(end)) {
                diffTwo++;
            }

            if (end >= k) {
                // the left most is outside of the window so remove it by comparing
                if (s.charAt(start) != altOne.charAt(start)) {
                    diffOne--;
                }
                if (s.charAt(start) != altTwo.charAt(start)) {
                    diffTwo--;
                }
                start++;
            }

            if (end >= k - 1) {
                minimumFlips = Math.min(minimumFlips, Math.min(diffOne, diffTwo));
            }
        }

        return minimumFlips;
    }
}
