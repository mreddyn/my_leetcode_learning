package com.leetcode.medium;

import java.util.Arrays;

public class MaximumWhiteTilesCoveredByCarpet {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int maxWhiteTilesCovered = 0;
        // sort the tiles by start index
        Arrays.sort(tiles, (a, b) -> (a[0] - b[0]));

        int start = 0, end = 0, tilesCovered = 0, n = tiles.length;
        while (start < n && end < n) {
            if (tiles[start][0] + carpetLen > tiles[end][1]) {
                // if the carpet can cover all the white tiles in the current range
                // then extend the window
                tilesCovered += tiles[end][1] - tiles[end][0] + 1;
                maxWhiteTilesCovered = Math.max(tilesCovered, maxWhiteTilesCovered);
                end++;
            } else {
                // if the carpet can not cover all the tiles in the range,
                // then we need to slide the carpet and remove previous white tiles
                // that are covered
                int partialTilesCovered = Math.max(0, tiles[start][0] + carpetLen - tiles[end][0]);
                maxWhiteTilesCovered = Math.max(maxWhiteTilesCovered, tilesCovered + partialTilesCovered);
                tilesCovered -= (tiles[start][1] - tiles[start][0] + 1);
                start++;
            }
        }

        return maxWhiteTilesCovered;
    }
}
