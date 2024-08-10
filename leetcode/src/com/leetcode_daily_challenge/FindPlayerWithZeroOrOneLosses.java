package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPlayerWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> winnersList = new ArrayList<>();
        List<Integer> playersWithZeroLoss = new ArrayList<>();
        List<Integer> playersWithOneLoss = new ArrayList<>();
        int totalMatches;
        totalMatches = matches.length;
        Map<Integer, Integer> playerLossCount = new HashMap<>();
        for (int match = 0; match < totalMatches; match++) {
            int winner = matches[match][0];
            int loser = matches[match][1];
            if (playerLossCount.get(winner) == null) {
                playerLossCount.put(winner, 0);
            }
            if (playerLossCount.get(loser) == null) {
                playerLossCount.put(loser, 1);
            } else {
                playerLossCount.put(loser, playerLossCount.getOrDefault(loser, 1) + 1);
            }
        }
        for(int player : playerLossCount.keySet()){
            int losses = playerLossCount.get(player);
            if(losses == 0){
                playersWithZeroLoss.add(player);
            }
            if(losses == 1){
                playersWithOneLoss.add(player);
            }
        }
        Collections.sort(playersWithZeroLoss);
        Collections.sort(playersWithOneLoss);
        winnersList.add(0, playersWithZeroLoss);
        winnersList.add(1, playersWithOneLoss);
        System.out.println(playerLossCount);
        return winnersList;
    }

    public static void main(String[] args) {
        System.out.println(new FindPlayerWithZeroOrOneLosses().findWinners(new int[][] { { 1, 3 }, { 2, 3 }, { 3, 6 },
                { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 10, 4 }, { 10, 9 } }));
    }
}
