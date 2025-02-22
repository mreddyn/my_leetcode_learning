package com.oa.company.rippling.currency_conversion;

import java.util.*;
import static java.lang.Math.*;

public class BellmanFordCurrencyConverter {

    // Edge representation: (from, to, cost)
    // cost will be -log(rate)
    record Edge(int from, int to, double cost) {};

    /**
     * Returns the best (maximum) conversion rate from 'from' to 'to'.
     * 
     * @param conversions Array of [sourceCurrency, targetCurrency, rateAsString]
     * @param from        Source currency
     * @param to          Target currency
     * @return The maximum conversion rate or -1.0 if no path exists.
     */
    public static double getBestConversionRate(String[][] conversions, String from, String to) {
        // If same currency, best conversion rate is 1.0
        if (from.equals(to)) {
            return 1.0;
        }

        // 1) Map each currency to a unique integer index
        Map<String, Integer> currencyIndex = new HashMap<>();
        int indexCount = 0;
        for (String[] c : conversions) {
            String c1 = c[0], c2 = c[1];
            if (!currencyIndex.containsKey(c1)) {
                currencyIndex.put(c1, indexCount++);
            }
            if (!currencyIndex.containsKey(c2)) {
                currencyIndex.put(c2, indexCount++);
            }
        }

        // If 'from' or 'to' aren't even present, we can’t convert
        if (!currencyIndex.containsKey(from) || !currencyIndex.containsKey(to)) {
            return -1.0;
        }

        int fromIdx = currencyIndex.get(from);
        int toIdx = currencyIndex.get(to);

        // 2) Build the edge list with cost = -log(rate)
        List<Edge> edges = new ArrayList<>();
        for (String[] c : conversions) {
            int u = currencyIndex.get(c[0]);
            int v = currencyIndex.get(c[1]);
            double rate = Double.parseDouble(c[2]);
            double cost = -log(rate); // transform to “log space”
            edges.add(new Edge(u, v, cost));
        }

        int V = currencyIndex.size();
        // 3) Initialize distance array
        double[] dist = new double[V];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[fromIdx] = 0.0;

        // 4) Bellman–Ford main loop: relax all edges (V - 1) times
        for (int i = 0; i < V - 1; i++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.from] != Double.POSITIVE_INFINITY
                        && dist[e.from] + e.cost < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.cost;
                    updated = true;
                }
            }
            // If no update in this pass, we can stop early
            if (!updated)
                break;
        }

        // 6) Interpret the final distance in log space
        if (dist[toIdx] == Double.POSITIVE_INFINITY) {
            // No path found
            return -1.0;
        } else {
            // Convert from “-log” distance back to a product
            return exp(-dist[toIdx]);
        }
    }

    // Demo main
    public static void main(String[] args) {
        // Example conversions
        // Format: {"fromCurrency", "toCurrency", "rate"}
        String[][] conversions = {
                { "USD", "EUR", "0.95" },
                { "USD", "INR", "80" },
                { "BTC", "USD", "30000" },
                { "EUR", "JPY", "137" },
                { "CNY", "RUB", "9.11" }
        };

        System.out.println("USD -> JPY: "
                + getBestConversionRate(conversions, "USD", "JPY"));
        System.out.println("BTC -> INR: "
                + getBestConversionRate(conversions, "BTC", "INR"));
        System.out.println("RUB -> USD: "
                + getBestConversionRate(conversions, "RUB", "USD")); // Likely -1
    }
}
