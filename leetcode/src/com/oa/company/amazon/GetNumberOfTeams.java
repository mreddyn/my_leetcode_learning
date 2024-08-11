package com.oa.company.amazon;

import java.util.Arrays;

public class GetNumberOfTeams {
    public long getNumTeams(int[] skill, int min_skill, int max_skill) {
        // write your code here
        long teamsCount = 0;
        int n = skill.length;
        // sort the skills array
        Arrays.sort(skill);

        for (int i = 0; i < n - 1; i++) {
            int start = i + 1;
            int end = n - 1;

            // find the lower bound where skill[i]+skill[start] >= min_skill
            int left = start;
            while (left < end && skill[i] + skill[left] < min_skill) {
                left++;
            }

            // find the upper bound where skill[i]+skill[end] <= max_skill
            int right = end;
            while (right >= left && skill[i] + skill[right] > max_skill) {
                right--;
            }

            // all pairs between left and right are valid
            teamsCount += right - left + 1;
        }
        return teamsCount;
    }

    public static void main(String[] args) {
        GetNumberOfTeams gOfTeams = new GetNumberOfTeams();
        System.out.println(gOfTeams.getNumTeams(new int[] { 2, 3, 4, 5 }, 5, 7));
    }
}
