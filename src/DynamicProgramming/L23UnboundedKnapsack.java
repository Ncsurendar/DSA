package DynamicProgramming;

import java.util.Arrays;

public class L23UnboundedKnapsack {

    static int helper(int ind, int W, int[] val, int[] wt, int[][] dp)
    {
        if(ind == 0)
        {
            return (int) W/wt[0] * val[0];
        }

        if(dp[ind][W] != -1) return dp[ind][W];
        int notTake = helper(ind-1, W, val, wt, dp);
        int take = 0;
        if(wt[ind] <= W) take = val[ind] + helper(ind, W - wt[ind], val, wt, dp);

        return dp[ind][W] = Math.max(notTake, take);
    }

    static int unboundedKnapsack(int n, int W, int[] val, int[] wt)
    {
        int[][] dp = new int[n][W+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(n-1, W, val, wt, dp);
    }

    public static void main(String[] args) {
        int[] wt = { 2, 4, 6 };
        int[] val = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack(n, W, val, wt));

    }
}
