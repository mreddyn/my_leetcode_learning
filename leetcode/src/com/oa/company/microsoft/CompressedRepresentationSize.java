package com.oa.company.microsoft;

public class CompressedRepresentationSize {
    /**
     * Returns the shortest compressed length possible by removing exactly K
     * consecutive characters from string s, then compressing.
     */
    public int shortestCompressedAfterRemoval(String s, int K) {
        int n = s.length();
        if (K <= 0 || K > n) {
            // Edge case: invalid K
            return compressLength(s);
        }
        if (K == n) {
            // Removing the entire string => empty => compressed length = 0
            return 0;
        }

        // Precompute runs for convenience (optional—helps if you want baseline info).
        // But for the simpler approach, we’ll just work directly from s each time.
        // This naive approach tries all possible removal substrings [L..L+K-1].

        int minLength = Integer.MAX_VALUE;

        for (int L = 0; L <= n - K; L++) {
            int R = L + K - 1; // inclusive end of removal segment

            // Build a new string that excludes s[L..R]
            // (Alternatively, you could do "run" manipulation. We’ll just remove and
            // re-compress for clarity.)
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, L)); // part before removal
            sb.append(s.substring(R + 1)); // part after removal

            // Now compress this new string
            int clength = compressLength(sb.toString());
            minLength = Math.min(minLength, clength);
        }

        return minLength;
    }

    /**
     * Computes the compressed length of the string (using the rules described):
     * - For each run of identical characters of length L:
     * if L == 1 => contributes 1 character to compression
     * if L > 1 => contributes (number of digits in L) + 1
     */
    private int compressLength(String s) {
        if (s.isEmpty())
            return 0;
        int length = 0;
        char prev = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                count++;
            } else {
                // finalize run of prev
                length += contribution(count);
                prev = s.charAt(i);
                count = 1;
            }
        }
        // finalize last run
        length += contribution(count);
        return length;
    }

    /**
     * Returns the compressed contribution of a run of length L:
     * - 1 char if L == 1
     * - (numberOfDigits(L) + 1) if L > 1
     */
    private int contribution(int L) {
        if (L == 1)
            return 1;
        return 1 + digitCount(L); // 1 for the character + digit count for L
    }

    private int digitCount(int num) {
        // simple approach:
        return Integer.toString(num).length();
    }

    // ---- Testing / Example main ----
    public static void main(String[] args) {
        var solver = new CompressedRepresentationSize();

        // Example 1:
        String s1 = "ABBBCCDDCCC";
        int k1 = 3;
        // One optimal removal is "DDC" => new string: "ABBBCCC" => compressed "A3B3C"
        // => length 5
        System.out.println(solver.shortestCompressedAfterRemoval(s1, k1)); // Expect 5

        // Example 2:
        String s2 = "ABCDDDCEFG";
        int k2 = 2;
        // One optimal removal is "EF" => new string "ABCDDDCG" => compressed "ABC3DCG"
        // => length 7
        // But the problem statement's example says the result is 6. Let's see if
        // there's a better removal:
        // If we remove "DD", we get "ABCDDCEFG" => compressed "ABC2DCEFG" => length 8
        // If we remove "DC" from the middle of "DDC", we get "ABCDDCEFG" => still
        // "ABC2DCEFG" => length 8
        // If we remove "CE", we get "ABCDDDFG" => compressed "ABC3DFG" => length 7
        // If we remove "DDC" partially => we can't remove 3 chars, only 2. Possibly the
        // sample says 6 is the answer,
        // so let's see if removing "DD" from the triple "DDD" merges something:
        // "ABCDDDCEFG" => remove the 2 middle 'D's => "ABC D CEFG" => there's still a
        // 'D' leftover => "ABCDC EFG"
        // compressed => "ABC D CEFG" => "ABC1DCEFG"? That's 9.
        // The sample says the result is 6 for removing "EF", giving "ABC3DG"? Wait,
        // that suggests that after removing "EF"
        // from "ABCDDDCEFG", they considered the string "ABCDDDCG" => then compressed
        // it as "ABC3DG" => length=6.
        // Let's see how "ABC3DG" arises:
        // Original: A B C D D D C E F G
        // Remove EF => A B C D D D C G
        // That is "ABCDDDCG"
        // Runs: A(1), B(1), C(1), D(3), C(1), G(1)
        // Compressed naive is: A B C 3D C G => 1+1+1+(1+1)+1+1=6 indeed.
        // We'll see if the method finds 6.
        int answer2 = solver.shortestCompressedAfterRemoval(s2, k2);
        System.out.println("Example2 answer = " + answer2); // Should print 6 if everything aligns

        // Another test:
        String s3 = "AAAAAAAAAAABXXAAAAAAAAAA";
        int k3 = 3;
        // Just a random check to see it runs.
        int answer3 = solver.shortestCompressedAfterRemoval(s3, k3);
        System.out.println("Example3 answer = " + answer3);
    }
}
