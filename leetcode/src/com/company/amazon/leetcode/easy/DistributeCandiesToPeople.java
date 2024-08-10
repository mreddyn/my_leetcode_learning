package com.company.amazon.leetcode.easy;

public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] finalDistribution = new int[num_people];
        int peopleIndex = 0, candiesForIthPerson = 1;
        while (candies > 0) {
            if (candiesForIthPerson <= candies) {
                finalDistribution[peopleIndex % num_people] += candiesForIthPerson;
                candies -= candiesForIthPerson;
                candiesForIthPerson++;
                peopleIndex++;
            } else {
                break;
            }

        }
        if (candies > 0) {
            finalDistribution[peopleIndex % num_people] += candies;
        }
        for (int i = 0; i < num_people; i++) {
            System.out.print(finalDistribution[i] + " ");
        }
        System.out.println();
        return finalDistribution;
    }

    public static void main(String[] args) {
        DistributeCandiesToPeople dCandiesToPeople = new DistributeCandiesToPeople();
        dCandiesToPeople.distributeCandies(7, 4);
        dCandiesToPeople.distributeCandies(10, 3);
        dCandiesToPeople.distributeCandies(60, 4);
    }
}
