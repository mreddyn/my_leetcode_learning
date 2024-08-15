package com.oa.company.tiktok;

import java.util.*;

public class NetworkSecurityUpgrade {
    // https://leetcode.com/discuss/interview-question/4939749/TikTok-OA

    public static int[] maxUpgradedServers(int[] num_servers, int[] money, int[] sell, int[] upgrade) {
        int n = num_servers.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int servers = num_servers[i];
            int funds = money[i];
            int upgradeCost = upgrade[i];
            int sellPrice = sell[i];

            // Calculate maximum upgrades with current funds
            int maxUpgrades = Math.min(servers, funds / upgradeCost);

            // Remaining servers and funds after initial upgrade
            int remainingServers = servers - maxUpgrades;
            funds -= maxUpgrades * upgradeCost;

            // Sell servers to upgrade more
            while (remainingServers > 0 && (funds + sellPrice) >= upgradeCost) {
                funds += sellPrice;
                remainingServers--;
                if (funds >= upgradeCost) {
                    maxUpgrades++;
                    funds -= upgradeCost;
                }
            }

            result[i] = maxUpgrades;
        }

        return result;
    }

    // Method to check if it's possible to upgrade a certain number of servers
    public static boolean doable(int numToUpgrade, int numServer, int money, int upgrade, int sell) {
        int requiredAmount = numToUpgrade * upgrade;
        if (requiredAmount <= money) {
            return true;
        }
        int delta = requiredAmount - money;
        int numToSell = delta / sell + (delta % sell > 0 ? 1 : 0);
        int remaining = numServer - numToSell;
        return remaining >= numToUpgrade;
    }

    // Binary search method to find the maximum number of servers that can be
    // upgraded
    public static int find(int server, int money, int upgrade, int sell) {
        int l = 0;
        int r = server;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (doable(mid, server, money, upgrade, sell)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    // Main solution method to solve the problem for all networks
    public static int[] solve(int[] servers, int[] money, int[] upgrade, int[] sell) {
        int n = servers.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = find(servers[i], money[i], upgrade[i], sell[i]);
        }
        return res;
    }

    public static int[] maxUpgrade(int[] num_servers, int[] money, int[] upgrade, int[] sell) {
        int n = num_servers.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            // While there are servers left and the available funds are enough to either
            // upgrade a server or sell a server
            if (num_servers[i] > 0 && money[i] >= upgrade[i]) {
                res[i] += Math.min(money[i] / upgrade[i], num_servers[i]);
                money[i] = (int) Math.floor(money[i] % upgrade[i]);
                num_servers[i] = num_servers[i] - res[i];// remaining servers
            }

            while (num_servers[i] > 0 && money[i] + sell[i] >= upgrade[i]) {
                num_servers[i] -= 2;
                res[i]++;
                money[i] = sell[i];
                money[i] -= upgrade[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] num_servers = { 4, 3 };
        int[] money = { 8, 9 };
        int[] sell = { 4, 2 };
        int[] upgrade = { 4, 5 };

        int[] result = maxUpgrade(num_servers, money, sell, upgrade);
        System.out.println(Arrays.toString(result)); // Output: [3, 2]
    }
}
