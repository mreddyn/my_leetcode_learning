package com.oa.company.microsoft.hiringevent;


public class SideLargestSquare {
    public int largestSquare(int m, int n) {
        // The total available area is m (from 1x1 tiles) plus 4*n (from 2x2 tiles).
        // This gives an upper bound on the side length of the square:
        int maxSide = (int) Math.sqrt(m + 4 * n);
        int result = 0;
        int low = 0;
        int high = maxSide;
        
        // Binary search for the maximum valid side length.
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormSquare(mid, m, n)) {
                result = mid;  // mid is a possible side length
                low = mid + 1; // try to see if we can go larger
            } else {
                high = mid - 1;
            }
        }
        
        return result;
    }
    
    // Helper method that checks if a square of side s can be formed.
    private boolean canFormSquare(int s, int m, int n) {
        // For a square of side s, the total area needed is s*s.
        // We try to cover as much area as possible with 2x2 tiles.
        // The maximum number of 2x2 placements inside a square of side s is floor(s/2)^2.
        int max2x2Placements = (s / 2) * (s / 2);
        // We can use at most n 2x2 tiles, so we take the minimum.
        int use2x2 = Math.min(n, max2x2Placements);
        
        // The area covered by the used 2x2 tiles is 4 * use2x2.
        // The remaining area must be covered by 1x1 tiles.
        int required1x1 = s * s - 4 * use2x2;
        
        // We can form the square if we have enough 1x1 tiles.
        return required1x1 <= m;
    }
    
    // Testing the solution with the given examples.
    public static void main(String[] args) {
        var sol = new SideLargestSquare();
        
        // Example 1:
        int m1 = 8, n1 = 0;
        System.out.println("Largest square side for m = " + m1 + ", n = " + n1 + ": " + sol.largestSquare(m1, n1));
        // Expected output: 2
        
        // Example 2:
        int m2 = 4, n2 = 3;
        System.out.println("Largest square side for m = " + m2 + ", n = " + n2 + ": " + sol.largestSquare(m2, n2));
        // Expected output: 4
    }
}
