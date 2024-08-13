package DynamicProgramming;

public class L38BestTimeToBuyAndSellStockIV {

    static int maximumProfit(int[] prices, int n, int k)
    {
        int[][] dp = new int[n + 1][2 * k + 1];
        for(int ind = n - 1; ind >= 0; ind--)
        {
            for(int tranNo = 2 * k - 1; tranNo >= 0; tranNo--)
            {
                if(tranNo % 2 == 0) // Buy call
                {
                    dp[ind][tranNo] = Math.max(-prices[ind] + dp[ind + 1][tranNo + 1], dp[ind + 1][tranNo]);
                }
                else                // Sell call
                {
                    dp[ind][tranNo] = Math.max(prices[ind] + dp[ind + 1][tranNo + 1], dp[ind + 1][tranNo]);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;
        int k = 2;

        System.out.println("The maximum profit that can be generated is " + maximumProfit(prices, n, k));
    }
}
