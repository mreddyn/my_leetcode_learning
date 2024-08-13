package com.oa.company.amazon;

import java.util.Arrays;
import java.util.HashSet;

public class FindUniqueValues {
    public int findUniqueValues(int[] experience) {
        int n = experience.length, left, right;
        Arrays.sort(experience);
        HashSet<Double> uniqueValuesSet = new HashSet<>();
        left = 0;
        right = n - 1;
        while (left < right) {
            double exp = (experience[left] + experience[right]) / 2.0;
            uniqueValuesSet.add(exp);
            left++;
            right--;
        }
        System.out.println(uniqueValuesSet);
        return uniqueValuesSet.size();
    }

    public static void main(String[] args) {
        FindUniqueValues fValues = new FindUniqueValues();
        System.out.println(fValues.findUniqueValues(new int[] { 1, 4, 1, 3, 5, 6 }));
        System.out.println(fValues.findUniqueValues(new int[] { 1, 100, 10, 1000 }));
    }
}
