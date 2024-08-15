package com.oa.company.tiktok;

import java.util.*;

public class SessionAuthentication {

    private int timeToLive;
    private Map<String, Integer> tokenMap;

    public SessionAuthentication(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenMap = new HashMap<>();
    }

    public int[] getUnexpiredTokens(int timeToLive, String[] queries) {
        List<Integer> results = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");
            String command = parts[0];
            int currentTime;
            String tokenId = "";
            if (command.equals("count")) {
                currentTime = Integer.parseInt(parts[1]);
            } else {
                tokenId = parts[1];
                currentTime = Integer.parseInt(parts[2]);
            }

            switch (command) {
                case "generate":
                    generateToken(tokenId, currentTime);
                    break;

                case "renew":
                    renewToken(tokenId, currentTime);
                    break;

                case "count":
                    results.add(countUnexpiredTokens(currentTime));
                    break;
            }
        }

        // Convert list to array
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private void generateToken(String tokenId, int currentTime) {
        int expirationTime = currentTime + timeToLive;
        tokenMap.put(tokenId, expirationTime);
    }

    private void renewToken(String tokenId, int currentTime) {
        if (tokenMap.containsKey(tokenId) && tokenMap.get(tokenId) > currentTime) {
            int newExpirationTime = currentTime + timeToLive;
            tokenMap.put(tokenId, newExpirationTime);
        }
    }

    private int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (int expirationTime : tokenMap.values()) {
            if (expirationTime > currentTime) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int timeToLive = 5;
        String[] queries = {
                "generate aaa 1",
                "renew aaa 2",
                "count 6",
                "generate bbb 7",
                "renew aaa 8",
                "renew bbb 10",
                "count 15"
        };

        SessionAuthentication sessionAuth = new SessionAuthentication(timeToLive);
        int[] results = sessionAuth.getUnexpiredTokens(timeToLive, queries);

        System.out.println(Arrays.toString(results)); // Output: [1, 0]
    }
}
