package DynamicProgramming;

public class L17CountSubsetsWithSumK {

    static int subsetcount(int[] arr, int sum)
    {
        int n = arr.length;
        int[][] dp = new int[n][sum+1];
        for(int i=0; i<n; i++) dp[i][0] = 1;

        if(arr[0] <= sum) dp[0][arr[0]] = 1;
        for(int i=1; i<n; i++)
        {
            for(int s=0; s<=sum; s++)
            {
                int notTake = dp[i-1][s];
                int take = 0;
                if(arr[i] <= s) take = dp[i-1][s-arr[i]];
                dp[i][s] = notTake + take;
            }
        }

        return dp[n-1][sum];
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {5,2,3,10,6,8};
        int sum = 10;
        int count = subsetcount(arr, sum);
        System.out.println(count);
    }
}
