package com.leetcode;

public class RemovingStarsFromString {
    private String removeStars(String s) {
        int sIndex = s.length() - 1;
        int sSkip = 0;
        StringBuilder sb = new StringBuilder();
        while (sIndex >= 0) {
            if (sIndex >= 0 && s.charAt(sIndex) == '*') {
                sSkip++;
                sIndex--;
                continue;
            }
            if (sSkip > 0) {
                sSkip--;
                sIndex--;
                continue;
            }
            if (sIndex < 0) {
                break;
            }
            sb.append(s.charAt(sIndex));
            sIndex--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemovingStarsFromString removingStarsFromString = new RemovingStarsFromString();
        String s = "leet**cod*e";
        System.out.println(removingStarsFromString.removeStars(s));
    }
}
