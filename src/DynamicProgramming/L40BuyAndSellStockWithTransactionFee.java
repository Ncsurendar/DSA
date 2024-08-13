package DynamicProgramming;

public class L40BuyAndSellStockWithTransactionFee {

    static int maximumProfit(int n, int fee, int[] prices)
    {
        int[][] dp = new int[n+1][2];

        for(int ind = n-1; ind>=0; ind--)
        {
            dp[ind][1] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind +1][1]);
            dp[ind][0] = Math.max(prices[ind] - fee + dp[ind + 1][1], dp[ind + 1][0]);
        }

        return dp[0][1];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int n = prices.length;
        int fee = 2;

        System.out.println("The maximum profit that can be generated is " + maximumProfit(n, fee, prices));
    }
}
