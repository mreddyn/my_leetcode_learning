package com.oa.company.tiktok;

public class CollectablePacks {
    public static int cardPackets(int[] cardTypes) {
        int n = cardTypes.length;
        int maxCards = 0;

        // Find the maximum number of cards in any type
        for (int count : cardTypes) {
            if (count > maxCards) {
                maxCards = count;
            }
        }

        // Initialize the result to a large number
        int minAdditionalCards = Integer.MAX_VALUE;

        // Iterate over possible numbers of packets (k) from 2 to maxCards
        for (int k = 2; k <= maxCards; k++) {
            int additionalCards = 0;

            // Calculate the number of additional cards needed for current k
            for (int count : cardTypes) {
                int remainder = count % k;
                if (remainder != 0) {
                    additionalCards += (k - remainder);
                }
            }

            // Update the minimum additional cards needed
            minAdditionalCards = Math.min(minAdditionalCards, additionalCards);
        }

        return minAdditionalCards;
    }

    public static void main(String[] args) {
        int[] cardTypes1 = { 4, 7, 5, 11, 15 };
        System.out.println(cardPackets(cardTypes1)); // Output: 4

        int[] cardTypes2 = { 3, 8, 7, 6, 4 };
        System.out.println(cardPackets(cardTypes2)); // Output: 2

        int[] cardTypes3 = { 3, 9, 7, 6, 5, 2 };
        System.out.println(cardPackets(cardTypes3)); // Output: 4
    }

}
