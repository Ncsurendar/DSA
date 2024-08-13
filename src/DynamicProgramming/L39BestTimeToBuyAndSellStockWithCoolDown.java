package DynamicProgramming;

public class L39BestTimeToBuyAndSellStockWithCoolDown {

    static int stockProfit(int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int ind = n-1; ind>=0; ind--)
        {
            dp[ind][1] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind +1][1]);
            dp[ind][0] = Math.max(prices[ind] + dp[ind + 2][1], dp[ind + 1][0]);
        }

        return dp[0][1];
    }

    public static void main(String[] args) {
        int[] prices = {4, 9, 0, 4, 10};
        System.out.println("The maximum profit that can be generated is " + stockProfit(prices));
    }
}
