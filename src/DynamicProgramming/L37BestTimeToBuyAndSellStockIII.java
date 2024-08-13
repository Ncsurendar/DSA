package DynamicProgramming;

import java.util.Arrays;

public class L37BestTimeToBuyAndSellStockIII {

    static int helper(int ind, int buy, int cap, int[] prices, int n, int[][][] dp)
    {
        if(ind == n || cap == 0) return 0;

        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        if(buy == 1)
        {
            return dp[ind][buy][cap] = Math.max(-prices[ind] + helper(ind + 1, 0, cap, prices, n, dp), helper(ind + 1, 1, cap, prices, n, dp));
        }
        return dp[ind][buy][cap] = Math.max(prices[ind] + helper(ind + 1, 1, cap - 1, prices, n, dp), helper(ind + 1, 0, cap, prices, n, dp));
    }


    static int maxProfit(int[] prices, int n)
    {
        int[][][] dp = new int[n][2][3];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<2; j++)
            {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0, 1, 2, prices, n, dp);
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;
        System.out.println("The maximum profit that can be generated is " + maxProfit(prices, n));
    }
}
