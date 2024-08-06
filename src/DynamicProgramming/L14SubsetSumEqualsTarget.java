package DynamicProgramming;

import java.util.Arrays;

public class L14SubsetSumEqualsTarget {

    static boolean helper(int ind, int target, int[] arr, int[][] dp)
    {
        if(target == 0) return true;
        if(ind == 0) return arr[0] == target;

        if(dp[ind][target] != -1) return dp[ind][target] != 0;
        boolean notTaken = helper(ind-1, target, arr, dp);
        boolean Taken = false;
        if(arr[ind] <= target) Taken = helper(ind-1, target - arr[ind], arr, dp);

        dp[ind][target] = notTaken || Taken ? 1 : 0;
        return notTaken || Taken;
    }

    static boolean subsetSumToK(int n, int k, int[] arr)
    {
        int[][] dp = new int[n][k+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return helper(n-1, k, arr, dp);
    }


    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;
        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
