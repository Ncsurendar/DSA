package DynamicProgramming;

public class L19Knapsack01Problem {

    static int knapSack(int W, int[] wt, int[] val, int n)
    {
        int[][] dp = new int[n][W+1];
        for(int weight=0; weight<=W; weight++)
        {
            if(wt[0] <= weight)
            {
                dp[0][weight] = val[0];
            }
        }

        for(int ind=1; ind<n; ind++)
        {
            for(int weight=0; weight<=W; weight++)
            {
                int notTake = 0 + dp[ind-1][weight];
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= weight) take = val[ind] + dp[ind-1][weight - wt[ind]];

                dp[ind][weight] = Math.max(take, notTake);
            }
        }

        return dp[n-1][W];
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;

        int maxValue = knapSack(W, wt, val, n);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
