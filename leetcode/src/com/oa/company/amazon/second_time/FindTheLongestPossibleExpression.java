package com.oa.company.amazon.second_time;

public class FindTheLongestPossibleExpression {
    public String findLongestRegex(String x, String y, String z) {
        int n = x.length();
        StringBuilder sb = new StringBuilder();
        int diffIdx = -1;
        int minLex = Integer.MIN_VALUE;
        String baseRegex = "[ABCDEFGHIJKLMNOPQRSTUVWXYZ]";
        for (int i = 0; i < n; i++) {
            if (x.charAt(i) == z.charAt(i) || y.charAt(i) == z.charAt(i)) {
                continue;
            }
            if (z.charAt(i) - 'A' > minLex) {
                diffIdx = i;
                minLex = z.charAt(i) - 'A';
            }
        }
        if (diffIdx == -1)
            return "-1";
        for (int i = 0; i < n; i++) {
            if (i == diffIdx) {
                sb.append(baseRegex.substring(0, minLex + 1));
                sb.append(baseRegex.substring(minLex + 2, baseRegex.length()));
            } else {
                sb.append(baseRegex);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FindTheLongestPossibleExpression obj = new FindTheLongestPossibleExpression();
        System.out.println(obj.findLongestRegex("AB", "BD", "CD"));
        System.out.println(obj.findLongestRegex("AERB", "ATRC", "AGCB"));
        System.out.println(obj.findLongestRegex("ABCD", "CODE", "CODE"));
    }
}
