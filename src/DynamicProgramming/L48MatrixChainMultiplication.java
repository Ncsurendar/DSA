package DynamicProgramming;

import java.util.Arrays;

public class L48MatrixChainMultiplication {

    static int helper(int i, int j, int[] arr, int[][] dp)
    {
        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k=i; k<j; k++)
        {
            int steps = arr[i-1] * arr[k] * arr[j] + helper(i, k, arr, dp) + helper(k+1, j, arr, dp);
            mini = Math.min(mini, steps);
        }

        return dp[i][j] = mini;
    }

    static int matrixMultiplication(int[] arr, int n)
    {
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(1, n-1, arr, dp);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int n = arr.length;
        System.out.println("The minimum number of operations are "+ matrixMultiplication(arr,n));
    }
}
