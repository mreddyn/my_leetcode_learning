package com.leetcode;

public class MaximumPopulationYear {
    private int maximumPopulation(int[][] logs) {
        int maxPopulationYear = 0;
        int[] years = new int[2051];
        for (int[] log : logs) {
            int birthYear = log[0];
            int deathYear = log[1];
            years[birthYear]++;
            years[deathYear]--;
        }
        for (int year = 1950; year < 2051; year++) {
            years[year] += years[year - 1];
            maxPopulationYear = years[year] > years[maxPopulationYear] ? year : maxPopulationYear;
        }

        return maxPopulationYear;
    }

    public static void main(String[] args) {
        MaximumPopulationYear maximumPopulationYear = new MaximumPopulationYear();
        System.out.println(maximumPopulationYear
                .maximumPopulation(new int[][] { { 1950, 1961 }, { 1960, 1971 }, { 1970, 1981 } }));
    }
}
