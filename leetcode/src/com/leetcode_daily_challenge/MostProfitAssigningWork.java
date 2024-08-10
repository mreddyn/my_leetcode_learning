package com.leetcode_daily_challenge;

import java.util.Arrays;
import java.util.Comparator;

public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0, totalJobs = difficulty.length, totalWorkers = worker.length;
        Job[] jobs = new Job[totalJobs];
        for (int i = 0; i < totalJobs; i++) {
            jobs[i] = new Job(profit[i], difficulty[i]);
        }
        // short the Jobs array in increasing order
        Comparator<Job> customComparator = new Comparator<>() {
            @Override
            public int compare(Job jobOne, Job jobTwo) {
                return jobOne.difficulty - jobTwo.difficulty;
            }
        };
        Arrays.sort(jobs, customComparator);

        // sort the worker array in increasing order
        Arrays.sort(worker);
        /*
         * if the current worker can do the job, we will assign him, and add the profit
         * to maxProfit
         * if the current worker can not do the job, then increase the pointer.
         */
        int workerIndex = 0, jobIndex = 0;
        while (workerIndex < totalWorkers) {
            int currentWorkerAbility = worker[workerIndex];
            int currentWorkerProfit = 0;
            for (jobIndex = 0; jobIndex < totalJobs; jobIndex++) {
                if (currentWorkerAbility >= jobs[jobIndex].difficulty) {
                    currentWorkerProfit = Math.max(currentWorkerProfit, jobs[jobIndex].profit);
                } else {
                    break;
                }
            }
            workerIndex++;
            maxProfit += currentWorkerProfit;

        }
        return maxProfit;
    }

    public int maxProfitAssignmentApproachTwo(int[] difficulty, int[] profit, int[] worker) {
        int totalJobs = difficulty.length, totalWorkers = worker.length, maxWorkerAbility = 0;
        // find the worker who has max ability
        for (int i = 0; i < totalWorkers; i++) {
            maxWorkerAbility = Math.max(worker[i], maxWorkerAbility);
        }

        int[] jobs = new int[maxWorkerAbility + 1];
        // iterate through difficulty and get the max profit a worker can achieve when
        // doing a job
        for (int i = 0; i < totalJobs; i++) {
            if (difficulty[i] <= maxWorkerAbility) {
                jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
            }
        }

        // Now fill maximum of prefixes
        for (int i = 1; i < jobs.length; i++) {
            jobs[i] = Math.max(jobs[i], jobs[i - 1]);
        }

        int netProfit = 0;
        for (int i = 0; i < totalWorkers; i++) {
            netProfit += jobs[worker[i]];
        }

        return netProfit;

    }

    class Job {
        int profit, difficulty;

        public Job(int profit, int difficulty) {
            this.profit = profit;
            this.difficulty = difficulty;
        }
    }

    public static void main(String[] args) {
        MostProfitAssigningWork mAssigningWork = new MostProfitAssigningWork();
        int[] difficulty = new int[] { 2, 4, 6, 8, 10 };
        int[] profit = new int[] { 10, 20, 30, 40, 50 };
        int[] worker = new int[] { 4, 5, 6, 7 };
        System.out.println(mAssigningWork.maxProfitAssignment(difficulty, profit, worker));
    }
}
