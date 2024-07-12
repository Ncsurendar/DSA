package GreedyAlgorithms;

import java.util.Arrays;

public class ShortestJobFirstCPUScheduling {

    static int shortestJobFirst(int[] jobs)
    {
        Arrays.sort(jobs);
        int n = jobs.length;
        int wt = 0, t = 0;
        for (int job : jobs) {
            wt += t;
            t += job;
        }
        return (wt/n);
    }

    public static void main(String[] args) {
        int[] jobs = {4, 3, 7, 1, 2};

        System.out.print("Array Representing Job Durations: ");
        for (int i = 0; i < jobs.length; i++) {
            System.out.print(jobs[i] + " ");
        }
        System.out.println();

        int ans = shortestJobFirst(jobs);
        System.out.println("Average waiting time: " + ans);
    }
}
