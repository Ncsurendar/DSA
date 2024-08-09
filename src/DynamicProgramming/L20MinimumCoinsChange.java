package DynamicProgramming;

public class L20MinimumCoinsChange {

    static int coinChange(int[] coins, int target)
    {
        int n = coins.length;
        int[][] dp = new int[n][target+1];

        for(int i=0; i<=target; i++)
        {
            if(i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = Integer.MAX_VALUE;
        }

        for(int ind=1; ind<n; ind++)
        {
            for(int t=0; t<=target; t++)
            {
                int notTake = dp[ind - 1][t];
                int take = Integer.MAX_VALUE;
                if(coins[ind] <= t)
                {
                    int res = dp[ind][t - coins[ind]];
                    if(res != Integer.MAX_VALUE) take = 1 + res;
                }
                dp[ind][t] = Math.min(notTake, take);
            }
        }

        if(dp[n-1][target] == Integer.MAX_VALUE) return -1;
        return dp[n-1][target];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 11;
        int result = coinChange(coins, target);
        if (result == -1) {
            System.out.println("It is not possible to make the target amount with the given coins.");
        } else {
            System.out.println("The minimum number of coins needed: " + result);
        }
    }
}
