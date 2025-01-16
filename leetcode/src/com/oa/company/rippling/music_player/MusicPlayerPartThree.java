package com.oa.company.rippling.music_player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class MusicPlayerPartThree {
    // map from SongId to SongInfo
    private final Map<Integer, SongInfo> songsMap = new HashMap<>();
    // next songId to assign
    private int nextSongId = 1;

    // for tracking each user's most recent unique songs plays
    // we wil use a deque to remove from the front and add to the back
    private Map<Integer, Deque<Integer>> userToRecentSongs = new HashMap<>();

    public int addSong(String title) {
        int currentSongId = nextSongId++;
        songsMap.put(currentSongId, new SongInfo(currentSongId, title, new HashSet<Integer>()));
        return currentSongId;
    }

    public void playSong(int songId, int userId) {
        var songInfo = songsMap.get(songId);
        var uniqueUsers = songInfo.uniqueUsers();
        uniqueUsers.add(userId);

        // update user's recent songs
        var recentSongs = userToRecentSongs.getOrDefault(userId, new ArrayDeque<>());

        // if the song is already in the recent songs, remove it
        recentSongs.remove(songId);

        // add the song to the front
        recentSongs.offerFirst(songId);

        // keep only the last 3
        if (recentSongs.size() > 3) {
            recentSongs.pollLast();
        }

        userToRecentSongs.put(userId, recentSongs);
    }

    /**
     * Prints the analytics summary:
     * - Sorted by descending number of unique users
     * - Includes song title and the number of unique users
     */
    public void printAnalyticsSummary() {
        songsMap.values().stream()
                .sorted((a, b) -> b.uniqueUsers().size() - a.uniqueUsers().size())
                .forEach(songInfo -> System.out.println(songInfo.title() + ": " + songInfo.uniqueUsers().size()));
    }

    /**
     * Part III:
     * Prints the top k songs by unique user count, in descending order.
     * Complexity: O(N log k) to find top k, then O(k log k) to sort them for
     * printing.
     */
    public void printTopSongsByUniqueUserCount(int k) {
        if(k <= 0) {
            return;
        }

        var minHeap = new PriorityQueue<SongInfo>((a, b) -> a.uniqueUsers().size() - b.uniqueUsers().size());

        for (var songInfo : songsMap.values()) {
            minHeap.offer(songInfo);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // now heap has top k songs but in ascending order
        // we will pop them and add to a list to reverse the order
        var topSongs = new ArrayDeque<SongInfo>();
        while (!minHeap.isEmpty()) {
            topSongs.offerFirst(minHeap.poll());
        }

        // print the top k songs
        System.out.println("Top " + k + " songs by unique user count:");
        for (var songInfo : topSongs) {
            System.out.println(songInfo.title() + ": " + songInfo.uniqueUsers().size());
        }
    }

    public void printRecentSongs(int userId) {
        var recentSongs = userToRecentSongs.get(userId);
        if (recentSongs == null) {
            System.out.println("No recent songs for user: " + userId);
            return;
        }

        System.out.println("Recent songs for user: " + userId);
        recentSongs.forEach(songId -> {
            var songInfo = songsMap.get(songId);
            System.out.println(songInfo.title());
        });
    }

    record SongInfo(int songId, String title, Set<Integer> uniqueUsers) {
    };
}
