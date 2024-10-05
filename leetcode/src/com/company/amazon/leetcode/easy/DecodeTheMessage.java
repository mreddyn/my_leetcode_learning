package com.company.amazon.leetcode.easy;

import java.util.HashMap;

public class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        int keySize = key.length(), messageSize = message.length();
        // maintain a hashmap to keep track of the mapping characters
        var keyMap = new HashMap<Character, Character>();

        char c = 'a';
        keyMap.put(' ', ' ');
        for (int i = 0; i < keySize; i++) {
            if (keyMap.containsKey(key.charAt(i))) {
                // if a char already has a mapping then ignore the current char.
                // as we only need to take the first occurrence
                continue;
            }
            keyMap.put(key.charAt(i), c++);
        }

        var decodedMessage = new char[messageSize];
        for (int i = 0; i < messageSize; i++) {
            char messageChar = message.charAt(i);
            char decodedChar = keyMap.get(messageChar);
            decodedMessage[i] = decodedChar;
        }

        return new String(decodedMessage);
    }

    public static void main(String[] args) {
        DecodeTheMessage dMessage = new DecodeTheMessage();
        System.out.println(dMessage.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out
                .println(dMessage.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
}
