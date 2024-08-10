package com.oa.company.uber;

public class Question1 {
    private static int[] solution(int []diffs){
        int n, highestRating, currentRating;
        n = diffs.length;
        highestRating = currentRating = 1500;
        for(int i=0;i<n;i++){
            currentRating += diffs[i];
            highestRating = Math.max(highestRating, currentRating);
        }
        return new int[]{highestRating, currentRating};
    }
    public static void main(String[] args) {
        int []diffs = {100,-200, 350, 100, -600};
        System.out.println(solution(diffs));
    }
}
