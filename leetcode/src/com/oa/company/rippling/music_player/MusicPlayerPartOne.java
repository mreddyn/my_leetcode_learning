package com.oa.company.rippling.music_player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class MusicPlayerPartOne {
    // map from SongId to SongInfo
    private final Map<Integer, SongInfo> songsMap = new HashMap<>();
    // next songId to assign
    private int nextSongId = 1;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public int addSong(String title) {
        int currentSongId = nextSongId++;
        songsMap.put(currentSongId, new SongInfo(currentSongId, title, new HashSet<>()));
        return currentSongId;
    }

    public void playSong(int songId, int userId) {
        SongInfo songInfo = songsMap.get(songId);
        var uniqueUsers = songInfo.uniqueUsers();
        uniqueUsers.add(userId);
    }

    /**
     * Prints the analytics summary:
     * - Sorted by descending number of unique users
     * - Includes song title and the number of unique users
     */
    public void printAnalyticsSummary() {
        songsMap.values().stream()
                .sorted((a, b) -> b.uniqueUsers().size() - a.uniqueUsers().size())
                .forEach(songInfo -> logger.info(songInfo.title() + ": " + songInfo.uniqueUsers().size()));
    }

    record SongInfo(int songId, String title, Set<Integer> uniqueUsers) {
    }

    public static void main(String[] args) {
        var player = new MusicPlayerPartOne();

        // Add a few songs
        int songId1 = player.addSong("Song A");
        int songId2 = player.addSong("Song B");
        int songId3 = player.addSong("Song C");

        // Simulate plays
        player.playSong(songId1, 101);
        player.playSong(songId1, 102);
        player.playSong(songId2, 101);
        player.playSong(songId2, 103);
        player.playSong(songId3, 105);
        player.playSong(songId3, 105); // same user playing again won't increase count

        // Print analytics summary
        player.printAnalyticsSummary();
    
    }
}
