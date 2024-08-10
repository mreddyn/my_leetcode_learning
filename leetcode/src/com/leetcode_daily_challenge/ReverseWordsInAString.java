package com.leetcode_daily_challenge;

public class ReverseWordsInAString {
    private static String reverseWords(String s) {
        /*
         * remove leading, trailing and extra spaces(between the words)
         * reverse the string
         * reverse each word
         */
        int n;
        n = s.length();
        String afterRemovingSpaces = removeSpaces(s);
        System.out.println("after removing spaces : " + afterRemovingSpaces);
        n = afterRemovingSpaces.length();
        char ch[] = afterRemovingSpaces.toCharArray();
        int left, right;
        left = 0;
        right = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == ' ') {
                right = i - 1;
                reverseString(ch, left, right);
                left = i + 1;
            }
        }
        reverseString(ch, left, n-1);
        reverseString(ch, 0, n-1);
        return new String(ch);
    }

    private static void reverseString(char ch[], int left, int right) {
        char temp;
        while (left < right) {
            temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }

    private static String removeSpaces(String s) {
        char ch[] = s.toCharArray();
        int n, index, left, right;
        index = 0;
        n = s.length();
        left = 0;
        right = n - 1;
        while (left <= right && ch[left] == ' ') {
            left++;
        }
        while (right >= left && ch[right] == ' ') {
            right--;
        }
        while (left <= right) {
            if (ch[left] == ' ' && left + 1 <= right && ch[left + 1] == ' ') {
            } else {
                ch[index++] = ch[left];
            }
            left++;
        }

        return String.valueOf(ch, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }
}
