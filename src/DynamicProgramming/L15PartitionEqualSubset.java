package DynamicProgramming;

import java.util.Arrays;

public class L15PartitionEqualSubset {

    static boolean helper(int ind, int target, int[] arr, int[][] dp)
    {
        if(target == 0) return true;
        if(ind == 0) return arr[0] == target;

        if(dp[ind][target] != -1) return dp[ind][target] != 0;
        boolean notTaken = helper(ind-1, target, arr, dp);
        boolean Taken = false;
        if(arr[ind] <= target)
        {
            Taken = helper(ind-1, target - arr[ind], arr, dp);
        }

        dp[ind][target] = notTaken || Taken ? 1 : 0;
        return notTaken || Taken;
    }

    static boolean subsetSumToK(int n, int target, int[] arr)
    {
        int[][] dp = new int[n][target + 1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return helper(n-1, target, arr, dp);
    }

    static boolean canPartition(int n, int[] arr)
    {
        int totSum = 0;
        for(int i=0; i<n; i++) totSum += arr[i];
        if(totSum % 2 != 0) return false;
        int target = totSum / 2;

        return subsetSumToK(n, target, arr);
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = arr.length;
        if (canPartition(n, arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }
}
