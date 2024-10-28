package com.company.amazon.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        int n = products.length, bsStart = 0, start = 0;
        String prefix = new String();
        for(char c : searchWord.toCharArray()) {
            prefix += c;

            // get the starting index of word starting with prefix
            start = lowerBound(products, bsStart, searchWord);

            // Add empty vector to result.
            result.add(new ArrayList<>());

            // Add the words with the same prefix to the result.
            // Loop runs until `i` reaches the end of input or 3 times or till the
            // prefix is same for `products[i]` Whichever comes first.
            for (int i = start; i < Math.min(start + 3, n); i++) {
                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
                    break;
                result.get(result.size() - 1).add(products[i]);
            }

            // Reduce the size of elements to binary search on since we know
            bsStart = Math.abs(start);
        }

        return result;
    }

    private int lowerBound(String[] products, int start, String word) {
        int left = start, right = products.length, mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (products[mid].compareTo(word) >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
