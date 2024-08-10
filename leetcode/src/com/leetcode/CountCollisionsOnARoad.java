package com.leetcode;

public class CountCollisionsOnARoad {
    private int countCollisions(String directions) {
        int totalNumOfCollisions = 0;
        int minStoppedCarIndex = Integer.MAX_VALUE;
        int maxStoppedCarIndex = Integer.MIN_VALUE;
        char directionsCharArray[] = directions.toCharArray();
        for (int index = 0; index < directionsCharArray.length; index++) {
            if (directionsCharArray[index] == 'R') {
                if (index + 1 < directionsCharArray.length && directionsCharArray[index + 1] == 'L') {
                    totalNumOfCollisions = totalNumOfCollisions + 2;
                    directionsCharArray[index] = 'S';
                    directionsCharArray[index + 1] = 'S';
                }
            } else if (directionsCharArray[index] == 'S') {
                minStoppedCarIndex = Math.min(minStoppedCarIndex, index);
                maxStoppedCarIndex = Math.max(maxStoppedCarIndex, index);
            } else {
                continue;
            }
        }
        for (int index = 0; index < directionsCharArray.length; index++) {
            if (directionsCharArray[index] == 'R' && index < maxStoppedCarIndex) {
                totalNumOfCollisions++;
            }
        }
        for (int index = directionsCharArray.length - 1; index >= 0; index--) {
            if (directionsCharArray[index] == 'L' && index > minStoppedCarIndex) {
                totalNumOfCollisions++;
            }
        }
        return totalNumOfCollisions;
    }

    public static void main(String[] args) {
        CountCollisionsOnARoad countCollisionsOnARoad = new CountCollisionsOnARoad();
        String directions = "RSSRLLRSLLRSRSSRLRRRRLLRRL";
        int result = countCollisionsOnARoad.countCollisions(directions);
        System.out.println(result);
    }
}
