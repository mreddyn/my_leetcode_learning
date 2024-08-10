package com.company.amazon.leetcode;

import java.util.PriorityQueue;

public class ReorganizeString {
    private String reorganizeString(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        PriorityQueue<CustomPair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                char c = (char) (i + 'a');
                int count = freq[i];
                pq.add(new CustomPair(c, count));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            System.out.println(sb.toString());
            CustomPair pair = pq.poll();
            if (sb.length() == 0 || (pair.c != sb.charAt(sb.length() - 1))) {
                sb.append(pair.c);

                if (pair.count > 1) {
                    int cCount = pair.count;
                    cCount--;
                    pq.add(new CustomPair(pair.c, cCount));
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }
                CustomPair pairTwo = pq.poll();
                sb.append(pairTwo.c);
                int cCount = pairTwo.count;
                if (cCount > 1) {
                    cCount--;
                    pq.add(new CustomPair(pairTwo.c, cCount));
                }
                pq.add(pair);
            }
        }

        return sb.toString();
    }

    class CustomPair {
        char c;
        int count;

        CustomPair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("aab"));
    }
}
