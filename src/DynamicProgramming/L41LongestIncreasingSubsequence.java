package DynamicProgramming;

import java.util.Arrays;

public class L41LongestIncreasingSubsequence {

    static int longestIncreasingSubsequence(int[] nums, int n)
    {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;

        for(int i=0; i<n; i++)
        {
            for(int prev=0; prev<i; prev++)
            {
                if(nums[prev] < nums[i])
                {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int n = arr.length;
        System.out.println("The length of the longest increasing subsequence is "+longestIncreasingSubsequence(arr,n));
    }
}
