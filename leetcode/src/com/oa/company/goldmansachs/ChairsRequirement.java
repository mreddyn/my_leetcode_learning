package com.oa.company.goldmansachs;

public class ChairsRequirement {
    public int[] minChair(String[] simulation) {
        if (simulation == null || simulation.length == 0) {
            return new int[0];
        }

        /*
         * There will be a string array of simulations. Each simulation is described by
         * a combination of four characters: C, R, U, and L
         * 
         * C - A new employee arrives in the workroom. If there is a chair available,
         * the employee takes it. Otherwise, a new one is purchased.
         * R - An employee goes to a meeting room, freeing up a chair.
         * U - An employee arrives from a meeting room. If there is a chair available,
         * the employee takes it. Otherwise, a new one is purchased.
         * L - An employee leaves the workroom, freeing up a chair.
         */

        int n = simulation.length;
        var res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = getMinChair(simulation[i]);
        }

        return res;
    }

    private int getMinChair(String simulation) {
        int n = simulation.length();
        int minChair = 0;
        int availableChair = 0;

        for (int i = 0; i < n; i++) {
            char c = simulation.charAt(i);
            if (c == 'C' || c == 'U') {
                if (availableChair == 0) {
                    minChair++;
                } else {
                    availableChair--;
                }
            } else if (c == 'R' || c == 'L') {
                availableChair++;
            }
        }

        return minChair;
    }

    public static void main(String[] args) {
        ChairsRequirement obj = new ChairsRequirement();
        String[] simulation = { "CRUL", "U", "R", "L" };
        var res = obj.minChair(simulation);
        for (var i : res) {
            System.out.println(i);
        }
    }
}
