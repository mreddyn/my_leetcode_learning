package com.company.wayfair.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leaderboard {
    private Map<Integer, Integer> idToScore;
    private Map<Integer, Integer> scoreToCount;

    public Leaderboard() {
        idToScore = new HashMap<>();
        scoreToCount = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        // if the player is not present then we add them
        if (!idToScore.containsKey(playerId)) {
            idToScore.put(playerId, score);
            scoreToCount.put(score, scoreToCount.getOrDefault(score, 0) + 1);
        } else {
            // if player already exists then update the score and also remove the old score
            // from TreeMap
            int oldScore = idToScore.get(playerId);
            scoreToCount.put(oldScore, scoreToCount.get(oldScore) - 1);
            // if there are no more players with the score then remove the mapping
            scoreToCount.remove(oldScore, 0);

            int newScore = oldScore + score;
            idToScore.put(playerId, newScore);
            scoreToCount.put(newScore, scoreToCount.getOrDefault(newScore, 0) + 1);
        }
    }

    public int top(int K) {
        int count = 0, sum = 0;

        for (int score : scoreToCount.keySet()) {
            int playerCount = scoreToCount.get(score);

            for (int i = 0; i < playerCount; i++) {
                sum += score;
                count++;

                if (count == K) {
                    break;
                }
            }

            if (count == K) {
                break;
            }
        }

        return sum;
    }

    public void reset(int playerId) {
        // we will the delete the mapping from idToScore
        int score = idToScore.get(playerId);

        // decrement the player count for this score
        scoreToCount.put(score, scoreToCount.get(score) - 1);
        scoreToCount.remove(score, 0);

        idToScore.remove(playerId);
    }
}
