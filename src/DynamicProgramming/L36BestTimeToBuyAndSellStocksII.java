package DynamicProgramming;

import java.util.Arrays;

public class L36BestTimeToBuyAndSellStocksII {

    static int helper(int ind, int buy, int[] arr, int n, int[][] dp)
    {
        if(ind == n) return 0;

        int profit = 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        if(buy == 1)
        {
            profit = Math.max(profit - arr[ind] + helper(ind + 1, 0, arr, n, dp), helper(ind + 1, 1, arr, n, dp));
        }
        else
        {
            profit = Math.max(profit + arr[ind] + helper(ind + 1, 1, arr, n, dp), helper(ind + 1, 0, arr, n, dp));
        }

        return dp[ind][buy] = profit;
    }


    static int getMaximumProfit(int[] arr, int n)
    {
        int[][] dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(0, 1, arr, n, dp);
    }


    public static void main(String[] args) {
        int n = 6;
        int[] Arr = {7, 1, 5, 3, 6, 4};

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
    }
}
