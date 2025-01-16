package com.oa.company.rippling.music_player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MusicPlayerPartTwo {
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

    public void printRecentSongs(int userId) {
        var recentSongs = userToRecentSongs.get(userId);
        if (recentSongs == null) {
            System.out.println("No recent songs for user: " + userId);
            return;
        }

        System.out.println("Recent songs for user: " + userId);
        for (var songId : recentSongs) {
            var songInfo = songsMap.get(songId);
            System.out.println(songInfo.title());
        }
    }


    

    record SongInfo(int songId, String title, Set<Integer> uniqueUsers) {
    };

    public static void main(String[] args) {
        var player = new MusicPlayerPartTwo();

        // Add a few songs
        // We'll name them to match the final requirement:
        // 1) Bohemian Rhapsody
        // 2) Stairway to Heaven
        // 3) Hello, Goodbye
        int songId1 = player.addSong("Bohemian Rhapsody");
        int songId2 = player.addSong("Stairway to Heaven");
        int songId3 = player.addSong("Hello, Goodbye");

        // Simulate plays for user ID 1
        player.playSong(songId1, 1); // plays Bohemian Rhapsody
        player.playSong(songId2, 1); // then Stairway to Heaven
        player.playSong(songId3, 1); // then Hello, Goodbye
        player.playSong(songId3, 1); // re-play Hello, Goodbye (still the most recent)

        // Let's print the last three played songs for user 1
        player.printRecentSongs(1);

        // You can still print analytics if you want
        System.out.println();
        player.printAnalyticsSummary();
    }
}
