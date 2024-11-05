package com.leetcode.easy;

public class ConfusingNumber {
    public boolean confusingNumber(int n) {
        String s = String.valueOf(n);
        var sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            // if we encounter 2 or 3 or 4 or 5 or 7 we can just return false
            // as rotating them would be invalid
            // if we encounter 9 then append 6
            // if we encounter 6 then append 9
            // other than that we can just append.
            // finally we will check after reversing it same or not to original
            if (ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '7') {
                return false;
            } else if (ch == '6') {
                sb.append('9');
            } else if (ch == '9') {
                sb.append('6');
            } else {
                sb.append(ch);
            }
        }

        return !sb.reverse().toString().equals(s);
    }
}
