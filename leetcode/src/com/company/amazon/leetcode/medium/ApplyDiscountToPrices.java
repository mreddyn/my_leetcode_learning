package com.company.amazon.leetcode.medium;

public class ApplyDiscountToPrices {
    public String discountPrices(String sentence, int discount) {
        /*
         * Due to precision do this question only in Python
         * Doing this question in Java sucks
         */
        String[] words = sentence.split(" ");
        StringBuilder finalSentence = new StringBuilder();
        for (String word : words) {
            if (word.charAt(0) == '$' && word.lastIndexOf('$') == 0) {
                int numPrice = Integer.parseInt(word.substring(1, word.length()));
                double discountedPrice = (double) ((numPrice * discount) / 100);
                double priceAfterDiscount = (double) (numPrice - discountedPrice);
                String priceAfterDiscountStr = String.valueOf(priceAfterDiscount);
                finalSentence.append('$');
                finalSentence.append(priceAfterDiscountStr);
                finalSentence.append(' ');

            } else {
                finalSentence.append(word);
                finalSentence.append(' ');
            }
        }
        finalSentence.deleteCharAt(finalSentence.length() - 1);
        return finalSentence.toString();
    }

    public static void main(String[] args) {
        ApplyDiscountToPrices aDiscountToPrices = new ApplyDiscountToPrices();
        System.out.println(aDiscountToPrices.discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
        System.out.println(aDiscountToPrices.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
    }
}
