package DynamicProgramming;

public class L22CoinChange2 {

    static int countWaysToMakeChange(int[] arr, int n, int target)
    {
        int[][] dp = new int[n][target + 1];
        for(int i=0; i<=target; i++)
        {
            if(i % arr[0] == 0) dp[0][i] = 1;
        }

        for(int ind=1; ind<n; ind++)
        {
            for(int t=0; t<=target; t++)
            {
                int notTake = dp[ind-1][t];
                int take = 0;
                if(arr[ind] <= t) take = dp[ind][t - arr[ind]];

                dp[ind][t] = notTake + take;
            }
        }

        return dp[n-1][target];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int target = 4;
        int n = arr.length;

        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));
    }
}
