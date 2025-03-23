package com.oa.company.guidewire;

public class PlaneSeating {

    // Map seat letters to indices 0..9 (skipping 'I')
    // A -> 0, B -> 1, C -> 2, D -> 3, E -> 4,
    // F -> 5, G -> 6, H -> 7, J -> 8, K -> 9
    private static int seatIndex(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            case 'J':
                return 8;
            case 'K':
                return 9;
            default:
                throw new IllegalArgumentException("Invalid seat letter: " + c);
        }
    }

    /**
     * Returns the maximum number of 4-person families that can be seated.
     * 
     * @param N number of rows in the plane
     * @param S space-separated string of reserved seats (e.g. "1A 1C 2F")
     */
    public int solution(int N, String S) {
        // If no seats are reserved, we can quickly calculate the max
        // families for all rows. Each row can hold up to 2 families
        // if seats are fully empty in the typical arrangement.
        if (S == null || S.isEmpty()) {
            // Each row can seat up to 2 families, so total = 2 * N
            return 2 * N;
        }

        // We'll store the reserved seats in each row using a bitmask
        // rowMask[i] = bitmask of reserved seats in row i (1-based indexing for row)
        // We’ll just use an array of length N+1 so row i can be directly referenced.
        int[] rowMask = new int[N + 1];

        // Parse the reserved seats string
        String[] tokens = S.split("\\s+");
        for (String seat : tokens) {
            // Example seat format: "3B"
            // row number is everything except last character
            // seat letter is the last character
            int len = seat.length();
            char letter = seat.charAt(len - 1);
            int row = Integer.parseInt(seat.substring(0, len - 1));

            // Mark this seat as reserved in the bitmask
            int idx = seatIndex(letter);
            // Set the bit at position idx
            rowMask[row] |= (1 << idx);
        }

        int totalFamilies = 0;

        // For each row, check how many 4-seat families we can fit
        for (int row = 1; row <= N; row++) {
            int mask = rowMask[row];

            // We'll attempt to place up to two families in each row
            int familiesInRow = 0;

            // Check block [2..5] in 1-based => seats B(1), C(2), D(3), E(4) in 0-based
            // That corresponds to bits 1,2,3,4 in the mask.
            boolean leftBlockFree = (mask & (0b1111 << 1)) == 0;

            // Check block [6..9] => seats F(5), G(6), H(7), J(8) in 0-based
            boolean rightBlockFree = (mask & (0b1111 << 5)) == 0;

            if (leftBlockFree) {
                familiesInRow++;
                // Mark these seats as used so we don't reuse them
                mask |= (0b1111 << 1);
            }
            if (rightBlockFree) {
                familiesInRow++;
                // Mark these seats as used
                mask |= (0b1111 << 5);
            }

            // If we haven’t placed 2 families yet, check the middle block [4..7]
            // => seats D(3), E(4), F(5), G(6) in 0-based
            // Only place a family here if we haven't already used them.
            if (familiesInRow < 2) {
                boolean middleBlockFree = (mask & (0b1111 << 3)) == 0;
                if (middleBlockFree) {
                    familiesInRow++;
                    // Mark them as used
                    mask |= (0b1111 << 3);
                }
            }

            totalFamilies += familiesInRow;
        }

        return totalFamilies;
    }

    // For quick testing
    public static void main(String[] args) {
        PlaneSeating ps = new PlaneSeating();

        // Example 1: N=2, no reservations => each row can seat 2 families => total = 4
        System.out.println(ps.solution(2, "")); // Expect 4

        // Example 2: Suppose N=1 and seats "1A 1C 1F"
        // The exact result depends on how the seats block families.
        // You can adjust or test with your own inputs.
        System.out.println(ps.solution(1, "1A 1C 1F"));
        System.out.println(ps.solution(22, "1A 3C 2B 20G 5A"));
    }
}
