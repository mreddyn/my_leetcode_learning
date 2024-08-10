package com.company.microsoft.leetcode;

public class MinimumNumberOfFoodBucketsToFeedHamsters {
    private int minimumBuckets(String hamsters) {
        int minBuckets = 0;
        /*
         * if hamsters string contains 'HHH' or startsWith 'HH' or endsWith 'HH' or only
         * 'H' then return -1
         */
        if (hamsters.equals("H") || hamsters.contains("HHH") || hamsters.startsWith("HH") || hamsters.endsWith("HH")) {
            return -1;
        }
        /*
         * for every hamster 'H' it needs one food bucket
         * for every two hamsters and empty 'H.H' we can save one food bucket by placing
         * in between hamsters
         * so the total required buckets is 'H' count - 'H.H' count
         * The number of "H" in s equals n - s.replace("H", "").length()
         * The number of "H.H" in s equals n - s.replace("H.H", " ").length()
         * so finally buckets = s.replace("H.H", "  ").length() -
         * s.replace("H","").length()
         */
        minBuckets = hamsters.replace("H.H", "  ").length() - hamsters.replace("H", "").length();
        return minBuckets;
    }

    public static void main(String[] args) {
        MinimumNumberOfFoodBucketsToFeedHamsters minimumNumberOfFoodBucketsToFeedHamsters = new MinimumNumberOfFoodBucketsToFeedHamsters();
        System.out.println(minimumNumberOfFoodBucketsToFeedHamsters.minimumBuckets("H.H"));
    }
}
