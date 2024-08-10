package com.leetcode;

public class FindIndexOfLargeInteger {
    private int getIndex(ArrayReader reader) {
        int n = reader.length();
        /*
         * if length is even, then the single larger integer may lie in first half or
         * second half
         * if length is odd, then the single larger integer may lie in three places
         * if we chop the array into three pieces, like middle will be one piece, and
         * the rest
         * 
         */
        int l = 0, r = n - 1, val;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((r - l) % 2 == 0) {
                val = reader.compareSub(l, mid, mid, r);
            } else {
                val = reader.compareSub(l, mid, mid + 1, r);
            }
            if (val == 1) {
                r = mid;
            } else if (val == -1) {
                l = mid + 1;
            } else if (val == 0) {
                return mid;
            }
        }

        return l;
    }

    interface ArrayReader {
        int compareSub(int l, int r, int x, int y);

        int length(); // returns the length of the array
    }
}
