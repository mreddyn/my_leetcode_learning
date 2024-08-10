package com.leetcode_explore.sorting;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int frequencyMap[] = new int[101];
        for (int height : heights) {
            frequencyMap[height]++;
        }
        int expected[] = new int[heights.length];
        int expectedIndex = 0;
        for(int index = 1; index < 101; index++){
            if(frequencyMap[index] != 0){
                int count = frequencyMap[index];
                while(count > 0){
                    expected[expectedIndex] = index;
                    expectedIndex++;
                    count--;
                }
            }
        }
        int heightDifferenceCount = 0;
        for(int index = 0; index < heights.length; index++){
            if(heights[index] != expected[index]){
                heightDifferenceCount++;
            }
        }

        return heightDifferenceCount;
    }
}
