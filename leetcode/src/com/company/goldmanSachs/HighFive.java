package com.company.goldmanSachs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!map.containsKey(id)) {
                map.put(id, new ArrayList<>());
            }
            map.get(id).add(score);
        }

        // loop through the map and calculate the top five average for each ID
        int uniqueIds = map.size(), resultIndex = 0;
        int[][] result = new int[uniqueIds][2];
        for (int id : map.keySet()) {
            List<Integer> scoreList = map.get(id);
            scoreList.sort((a, b) -> b - a);
            int scoreSum = 0, topFiveAverage = 0;
            for (int i = 0; i < 5; i++) {
                scoreSum += scoreList.get(i);
            }
            topFiveAverage = scoreSum / 5;
            result[resultIndex][0] = id;
            result[resultIndex][1] = topFiveAverage;
            resultIndex++;
        }

        return result;
    }
}
