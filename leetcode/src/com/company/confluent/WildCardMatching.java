package com.company.confluent;
/*
 * Click `Run` to execute the snippet below!
 */


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// Given an input string (v) and a pattern, implement a wildcard matching function with support for literal
// characters a through z and the wildcard character * (which matches zero or more of any character)
// static boolean isMatch(String v, String pattern);

// aa a*


// abcd c* --> false.
// abcd a* --> bcd *
// abcd *cd --> (abcd, cd)|| (bcd, *cd) -> (bcd, cd) || (cd, *cd) -> (cd, cd) ||
// "", * --> return true;

// cat *t*a*c* --> (cat t*a*c*) || (at, *t*a*c) -> (at, t*a*c) || (t, *t*a*c) -> (t, t*a*c) || ("", *t*a*c)
// (t, t*a*c) -> ("", *a*c)


class WildCardMatching {

    public static void main(String[] args) {
        // System.out.println(isMatch("cat", "*t*a*c*"));
        assertEquals(true, isMatch("cat", "*t"));
        assertEquals(false, isMatch("dog", "c*t"));
        assertEquals(true, isMatch("", ""));
        assertEquals(true, isMatch("", "*"));
        assertEquals(true, isMatch("asdfkjasldkfj", "*"));
        assertEquals(true, isMatch("cat", "cat"));
        assertEquals(true, isMatch("catat", "ca*t"));
        assertEquals(false, isMatch("cat", "cat*cat"));
        assertEquals(false, isMatch("cart", "c*at"));
        assertEquals(true, isMatch("v", "v*"));
        assertEquals(true, isMatch("v", "*v"));
        assertEquals(true, isMatch("v", "*v"));
        assertEquals(true, isMatch("aa", "a*a"));


        assertEquals(true, isMatch("", "****"));
        assertEquals(false, isMatch("cat", "c*t*t"));
        assertEquals(false, isMatch("dogcat", "*cat*cat"));
        assertEquals(false, isMatch("catdog", "cat*cat*"));
        assertEquals(true, isMatch("catcatttcat", "cat*cat*cat****"));
        assertEquals(false, isMatch("dogcatcatttcat", "cat*cat*cat****"));
        assertEquals(true, isMatch("catfdafdacaterdfgscat", "cat***cat***cat****"));
        assertEquals(true, isMatch("catcatcat", "cat*cat*cat***"));
        assertEquals(true, isMatch("catcatcat", "****cat*cat*cat***"));
        assertEquals(true, isMatch("fdajhfjdsacatcatcatlsaflk", "****cat*cat*cat***"));
        assertEquals(false, isMatch("abbb", "cat*abc*"));
        assertEquals(true, isMatch("t", "*t"));

        System.out.println("All Done");
    }


    // greedy solution with idea of DFS
    // starj stores the position of last * in p
    // last_match stores the position of the previous matched char in s after a *
    // e.g.
    // s: a c d s c d
    // p: * c d
    // after the first match of the *, starj = 0 and last_match = 1
    // when we come to i = 3 and j = 3, we know that the previous match of * is actually wrong,
    // (the first branch of DFS we take is wrong)
    // then it resets j = starj + 1
    // since we already know i = last_match will give us the wrong answer
    // so this time i = last_match+1 and we try to find a longer match of *
    // then after another match we have starj = 0 and last_match = 4, which is the right solution
    // since we don't know where the right match for * ends, we need to take a guess (one branch in DFS),
    // and store the information(starj and last_match) so we can always backup to the last correct place and take another guess.

    // time: o(slen+plen)
    // Worst case definitely not linear. Should be O(slen*plen)
    //think that s ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" to match p ="*aaaaaab"( '*' in the beginning)
    //It's easy to see 'match' is moving step by step to almost the end, each time we move 'match',
    // we will go through the whole tail of p (after '*') until we found out 'b' is not a match. Thus it's O(NM)

    static boolean isMatch(String str, String pat) {
        int sIdx = 0, pIdx = 0, last_match = 0, starIdx = -1, sLen = str.length(), pLen = pat.length();
        //  starIdx stores the position of last * in p
        // last_match stores the position of the previous matched char in s.
        while (sIdx < sLen) {
            if (pIdx < pLen && (str.charAt(sIdx) == pat.charAt(pIdx))) {
                // advancing both pointers
                sIdx++;
                pIdx++;
            } else if (pIdx < pLen && pat.charAt(pIdx) == '*') {
                // * found, only advancing pattern pointer
                last_match = sIdx;
                starIdx = pIdx;
                pIdx++;
            } else if (starIdx != -1) {
                // last pattern pointer was *, advancing string pointer
                pIdx = starIdx + 1;
                last_match++;
                sIdx = last_match;
            } else {
                // current pattern pointer is not star, last patter pointer was not *
                // characters do not match
                return false;
            }
        }
        // check for remaining characters in pattern
        while (pIdx < pLen && pat.charAt(pIdx) == '*') pIdx++;
        return pIdx == pLen;
    }


    static Boolean[][] mem;

    // time: O(slen*plen)
    static boolean isMatchr(String s, String p) {
        mem = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(0, s, 0, p);
    }

    static boolean isMatch(int i, String s, int j, String p) {
        int sn = s.length(), pn = p.length();
        if (j == pn) {
            return i == sn;
        }
        if (mem[i][j] != null) {
            return mem[i][j];
        }
        char pj = p.charAt(j);
        if (pj == '*') {
            return mem[i][j] = isMatch(i, s, j + 1, p) || i < sn && isMatch(i + 1, s, j, p);
        } else if (i < sn && pj == s.charAt(i)) {
            return mem[i][j] = isMatch(i + 1, s, j + 1, p);
        }
        return mem[i][j] = false;
    }


    // https://leetcode.com/problems/wildcard-matching/discuss/17859/Evolve-from-brute-force-to-optimal
    // https://leetcode.com/problems/wildcard-matching/discuss/1001130/C%2B%2B-Clean-and-concise-bottom-up-dp-code-with-detailed-explanation-easy-to-understand.
    static boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < p.length() && p.charAt(j) == '*'; ++j) {
            dp[0][j + 1] = true;
        }
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && dp[i - 1][j - 1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }


    public static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) {
            throw new AssertionError("Expected " + expected + " but found " + actual);
        }
    }


}

