package com.company.amazon.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumNumberOfKeyPresses {
    private int minimumKeyPresses(String s) {
        int keyPressCount = 0, n = s.length(), numpadRoundRobin = 1;
        /*
         * calculate the frequency of each char, and try to assign the numpad for high
         * frequency char first
         * 
         */
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<CustomPair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (char key : charFreqMap.keySet()) {
            int freq = charFreqMap.get(key);
            pq.add(new CustomPair(key, freq));
        }
        HashMap<Character, Integer> charMap = new HashMap<>();

        while (!pq.isEmpty()) {
            CustomPair pair = pq.poll();
            int mapSize = charMap.size();
            if (charMap.containsKey(pair.ch)) {
                continue;
            } else if (mapSize >= 9 && mapSize < 18) {
                numpadRoundRobin = 2;
            } else if (mapSize >= 18) {
                numpadRoundRobin = 3;
            }
            charMap.put(pair.ch, numpadRoundRobin);
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            keyPressCount += charMap.get(c);
        }
        System.out.println(charFreqMap);
        System.out.println(charMap);
        return keyPressCount;
    }

    class CustomPair {
        char ch;
        int freq;

        CustomPair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    private int minimumKeyPressApproachTwo(String s) {
        int keyPressCount = 0, n = s.length(), numpadRoundRobin = 0;
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        for (int i = 25; i >= 0; i--) {
            // for 0-9 assign 1, 10-18 assign 2, and 3 for rest
            keyPressCount += (freq[i] * (numpadRoundRobin / 9 + 1));
            numpadRoundRobin++;
        }
        return keyPressCount;
    }

    public static void main(String[] args) {
        MinimumNumberOfKeyPresses minimumNumberOfKeyPresses = new MinimumNumberOfKeyPresses();
        System.out.println(minimumNumberOfKeyPresses.minimumKeyPresses("aaaaaaaabcdefgggghijkllllllllllmmmnoppponono"));
        System.out.println(
                minimumNumberOfKeyPresses.minimumKeyPressApproachTwo("aaaaaaaabcdefgggghijkllllllllllmmmnoppponono"));
    }
}
