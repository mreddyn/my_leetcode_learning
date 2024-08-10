package com.oa.company.amazon;

import java.util.Arrays;

public class PrimeVideosQuestion {
    private int minimumTimeSpent(int[] comedyReleaseTime, int[] comedyDuration, int[] dramaReleaseTime,
            int[] dramaDuration) {
        Arrays.sort(comedyReleaseTime);
        Arrays.sort(dramaReleaseTime);

        int earliestTime = Integer.MAX_VALUE;

        for (int i = 0; i < comedyReleaseTime.length; i++) {
            for (int j = 0; j < dramaReleaseTime.length; j++) {
                int comedyStart = comedyReleaseTime[i];
                int dramaStart = dramaReleaseTime[j];

                int comedyEnd = comedyStart + comedyDuration[i];
                int dramaEnd = dramaStart + dramaDuration[j];

                int finishTime = Math.max(comedyEnd, dramaEnd);
                earliestTime = Math.min(earliestTime, finishTime);
            }
        }

        return earliestTime;
    }

    private int minimumTimeSpentTwo(int[] comedyReleaseTime, int[] comedyDuration, int[] dramaReleaseTime,
            int[] dramaDuration) {
        int minTimeWhenFirstMovieEnds = Integer.MAX_VALUE;
        for (int i = 0; i < comedyReleaseTime.length; i++)
            minTimeWhenFirstMovieEnds = Math.min(minTimeWhenFirstMovieEnds, comedyReleaseTime[i] + comedyDuration[i]);

        // now we need to check which movie from second genre should we see to get min
        // time overall.
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dramaReleaseTime.length; i++) {
            int overallEndTime;
            if (dramaReleaseTime[i] <= minTimeWhenFirstMovieEnds)
                overallEndTime = minTimeWhenFirstMovieEnds + dramaDuration[i];
            else
                overallEndTime = dramaReleaseTime[i] + dramaDuration[i];
            ans = Math.min(ans, overallEndTime);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] comedyReleaseTime = { 1, 2, 3 };
        int[] comedyDuration = { 1, 1, 1 };
        int[] dramaReleaseTime = { 1, 2, 3 };
        int[] dramaDuration = { 10, 5, 1 };
        PrimeVideosQuestion primeVideosQuestion = new PrimeVideosQuestion();
        System.out.println(primeVideosQuestion.minimumTimeSpent(comedyReleaseTime, comedyDuration, dramaReleaseTime,
                dramaDuration));
        System.out.println(primeVideosQuestion.minimumTimeSpentTwo(comedyReleaseTime, comedyDuration, dramaReleaseTime,
                dramaDuration));
    }
}
