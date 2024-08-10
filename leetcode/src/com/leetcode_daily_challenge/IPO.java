package com.leetcode_daily_challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int maximizedCapital = 0, n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        Arrays.sort(projects);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        return maximizedCapital;
    }

    class Project implements Comparable<Project> {
        int capital, profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Project project) {
            return this.capital - project.capital;
        }

    }
}
