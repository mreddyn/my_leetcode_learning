package com.oa.company.amazon;

import java.util.Arrays;

public class QuestionOne {
    public static int findMinimumNumberOfPages(int[] pages, int days) {
        int left = 1;
        int right = Integer.MAX_VALUE;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(pages, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canFinish(int[] pages, int days, int x) {
        int daysNeeded = 0;

        for (int page : pages) {
            daysNeeded += (int) Math.ceil((double) page / x);
        }

        return daysNeeded <= days;
    }

    public static void main(String[] args) {
        int[] pages = { 2, 3, 4 };
        int days = 4;
        System.out.println(findMinimumNumberOfPages(pages, days));
    }
}
