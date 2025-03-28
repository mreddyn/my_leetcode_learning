package com.oa.company.microsoft.hiringevent;

public class MinimumSwapsRequiredToGroupRedBalls {
    public int minSwaps(String colors) {
        /*
         * Given 2 balls Red and White, return the minum number of swaps required where
         * we want to arrange all the red balls into consistent segment ( in one move,
         * you can swap adjacent ones)
         * 
         * Example 1:
         * 
         * Input: colors = "WRRWRW"
         * Output: 2
         */
        int n = colors.length();
        int redTotal = 0;

        for (int i = 0; i < n; i++) {
            if (colors.charAt(i) == 'R') {
                redTotal++;
            }
        }

        if (redTotal == 0 || redTotal == 1 || redTotal == n) {
            return 0;
        }

        int maxRedInWindow = 0;
        int redInWindow = 0;
        int windowSize = redTotal;
        int start = 0;

        for (int end = 0; end < n; end++) {
            if (colors.charAt(end) == 'R') {
                redInWindow++;
            }

            if (end - start + 1 > windowSize) {
                if (colors.charAt(start) == 'R') {
                    redInWindow--;
                }
                start++;
            }

            maxRedInWindow = Math.max(maxRedInWindow, redInWindow);
        }

        return redTotal - maxRedInWindow;
    }

    public static void main(String[] args) {
        var obj = new MinimumSwapsRequiredToGroupRedBalls();
        System.out.println(obj.minSwaps("WRRWRW"));
    }
}
