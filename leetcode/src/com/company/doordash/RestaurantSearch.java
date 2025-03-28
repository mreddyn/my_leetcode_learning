package com.company.doordash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantSearch {
    private List<List<String>> searchRes(String[] restaurants, String[] queries, int k) {
        Trie root = new Trie();
        for (String restaurant : restaurants) {
            Trie node = root;
            for (char c : restaurant.toCharArray()) {
                node.children.putIfAbsent(c, new Trie());
                node = node.children.get(c);
                node.restaurants.add(restaurant);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String query : queries) {
            Trie node = root;
            for (char c : query.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    res.add(new ArrayList<>());
                    break;
                }
                node = node.children.get(c);
            }

            if (node != root) {
                System.out.println(node.restaurants);
                res.add(node.restaurants.subList(0, Math.min(k, node.restaurants.size())));
            }
        }

        return res;
    }

    class Trie {
        Map<Character, Trie> children;
        List<String> restaurants;

        Trie() {
            children = new HashMap<>();
            restaurants = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        RestaurantSearch restaurantSearch = new RestaurantSearch();
        String[] restaurants = { "abc", "abcd", "dec", "da", "ade" };
        String[] queries = { "a", "d" };
        int k = 2;
        System.out.println(restaurantSearch.searchRes(restaurants, queries, k));

    }
}
