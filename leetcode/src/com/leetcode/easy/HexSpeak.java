package com.leetcode.easy;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HexSpeak {
    public String toHexSpeak(String num) {
        HashSet<Character> set = Stream.of('A', 'B', 'C', 'D', 'E', 'F', 'I', 'O')
                .collect(Collectors.toCollection(HashSet::new));
        String hexString = Long.toHexString(Long.parseLong(num)).toUpperCase();
        char[] ch = hexString.toCharArray();
        System.out.println(hexString);
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                ch[i] = 'I';
            }
            if (ch[i] == '0') {
                ch[i] = 'O';
            }
            if (!set.contains(ch[i])) {
                return "ERROR";
            }
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        HexSpeak hexSpeak = new HexSpeak();
        System.out.println(hexSpeak.toHexSpeak("257"));
        System.out.println(hexSpeak.toHexSpeak("747823223228"));
    }
}
