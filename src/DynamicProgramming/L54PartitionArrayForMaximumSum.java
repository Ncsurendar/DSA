package DynamicProgramming;

import java.util.Arrays;

public class L54PartitionArrayForMaximumSum {

    static int helper(int ind, int n, int[] arr, int k, int[] dp)
    {
        if(ind == n) return 0;
        if(dp[ind] != -1) return dp[ind];
        int len = 0, maxi = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;
        for(int j=ind; j<Math.min(ind + k, n); j++)
        {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = (len * maxi) + helper(j + 1, n, arr, k, dp);
            maxAns = Math.max(maxAns, sum);
        }

        return dp[ind] = maxAns;
    }

    static int maxSumAfterPartition(int[] arr, int k)
    {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, n, arr, k, dp);
    }

    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;
        int ans = maxSumAfterPartition(arr,k);
        System.out.println(ans);
    }
}
