package com.oa.company.tiktok;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class ByteDanceRepairCenter {
    // https://leetcode.com/discuss/interview-question/5139845/Tiktok-OA-2024

    public static long repairComputers(int[] cost, int[] numComputers) {
        Arrays.sort(cost);
        Arrays.sort(numComputers);

        int n = cost.length;
        int m = numComputers.length;
        long totalCost = 0;
        boolean[] repaired = new boolean[n];
        int remainingComputers = n;

        for (int i = m - 1; i >= 0; i--) {
            int computersToRepair = numComputers[i];
            int selectedCount = 0;
            long currentCost = 0;
            int minSelectedCost = Integer.MAX_VALUE;

            // Select computers for the current machine
            for (int j = n - 1; j >= 0 && selectedCount < computersToRepair; j--) {
                if (!repaired[j]) {
                    currentCost += cost[j];
                    minSelectedCost = Math.min(minSelectedCost, cost[j]);
                    repaired[j] = true;
                    selectedCount++;
                    remainingComputers--;
                }
            }

            // Try to add up to 2 more computers with no cost
            int freeComputersAdded = 0;
            for (int j = 0; j < n && freeComputersAdded < 2 && remainingComputers > 0; j++) {
                if (!repaired[j] && cost[j] <= minSelectedCost) {
                    repaired[j] = true;
                    freeComputersAdded++;
                    remainingComputers--;
                }
            }

            totalCost += currentCost;
        }

        return totalCost;
    }

    public static int findMinCost(int[] cost, int[] numComputers) {
        // Sort the cost array and numComputers array
        Arrays.sort(cost);
        Arrays.sort(numComputers);

        int i = 0; // starting index of the machines
        int ans = 0;

        // Create a stack to simulate the pop operation in Python
        Deque<Integer> costStack = new ArrayDeque<>();
        for (int j = cost.length - 1; j >= 0; j--) {
            costStack.push(cost[j]);
        }

        while (!costStack.isEmpty()) {
            int remComps;
            if (i < numComputers.length) {
                remComps = numComputers[i];
            } else {
                remComps = Integer.MAX_VALUE;
            }

            // While remComps is greater than 0 and there are still costs to pop
            while (remComps > 0 && !costStack.isEmpty()) {
                ans += costStack.pop();
                remComps--;
            }
            i++;

            int upToTwo = 2;
            // Removing up to two most remaining expensive computers freely
            while (!costStack.isEmpty() && upToTwo > 0) {
                costStack.pop();
                upToTwo--;
            }
        }

        return ans;
    }

    public static int solve(List<Integer> costs, List<Integer> numComputers) {
        int totalCost = 0;

        // Sort costs and numComputers in ascending order
        Collections.sort(costs);
        Collections.sort(numComputers);

        // Reverse the lists to easily pop the largest elements from the end
        Collections.reverse(costs);

        for (int n : numComputers) {
            for (int i = 0; i < n && !costs.isEmpty(); i++) {
                // Pop the largest element from the costs list and add it to total cost
                totalCost += costs.get(0);
                costs.remove(0);
            }
            // Remove up to 2 more elements freely (most expensive remaining ones)
            for (int i = 0; i < 2 && !costs.isEmpty(); i++) {
                costs.remove(0);
            }
        }

        // Sum any remaining costs
        for (int remainingCost : costs) {
            totalCost += remainingCost;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] cost1 = { 1, 2, 4, 6, 10 };
        int[] numComputers1 = { 1, 2 };
        System.out.println("Minimum repair cost: " + repairComputers(cost1, numComputers1)); // Output: 13
        System.out.println("Minimum repair cost: " + findMinCost(cost1, numComputers1)); // Output: 13

        int[] cost2 = { 5, 4, 3, 2, 1 };
        int[] numComputers2 = { 2, 3 };
        System.out.println("Minimum repair cost: " + repairComputers(cost2, numComputers2)); // Output: 10
        System.out.println("Minimum repair cost: " + findMinCost(cost2, numComputers2)); // Output: 10

        int[] cost3 = { 1, 2, 3, 4, 5 };
        int[] numComputers3 = { 1, 3 };
        System.out.println("Minimum repair cost: " + repairComputers(cost3, numComputers3)); // Output: 6
        System.out.println("Minimum repair cost: " + findMinCost(cost3, numComputers3)); // Output: 6

        // Test cases
        System.out.println(solve(Arrays.asList(1, 2, 4, 6, 10), Arrays.asList(1, 2, 3))); // Output: 13
        System.out.println(solve(Arrays.asList(1, 2, 4, 6, 10), Arrays.asList(3))); // Output: 20
        System.out.println(solve(Arrays.asList(1, 2, 4, 6, 10), new ArrayList<>())); // Output: 23
        System.out.println(solve(Arrays.asList(4, 10, 2, 6, 1), Arrays.asList(1, 2))); // Output: 13
        System.out.println(solve(Arrays.asList(24592, 26641, 24267, 3965, 3435), Arrays.asList(3, 1))); // Output: 34041
        System.out.println(solve(Arrays.asList(18080, 4198, 524, 9768, 14103), Arrays.asList(4, 3, 3, 5))); // Output:
                                                                                                            // 41951
        System.out.println(solve(Arrays.asList(16822, 28219, 28738, 10686, 31065, 10115, 32138), Arrays.asList(5, 7))); // Output:
                                                                                                                        // 136982
        System.out
                .println(solve(Arrays.asList(16768, 23257, 4291, 30969, 16932, 3295, 7981), Arrays.asList(1, 3, 3, 2))); // Output:
                                                                                                                         // 55718
    }
}
