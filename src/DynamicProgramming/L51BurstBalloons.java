package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L51BurstBalloons {

    static int helper(int i, int j, List<Integer> arr, int[][] dp)
    {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int maxi = Integer.MIN_VALUE;
        for(int ind=i; ind<=j; ind++)
        {
            int cost = arr.get(i-1) * arr.get(ind) * arr.get(j+1) + helper(i, ind-1, arr, dp) + helper(ind+1, j, arr, dp);
            maxi = Math.max(maxi, cost);
        }

        return dp[i][j] = maxi;
    }

    static int maxCoins(int[] nums)
    {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        for(int it : nums) arr.add(it);
        arr.add(1);

        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return helper(1, n, arr, dp);
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        int ans = maxCoins(nums);
        System.out.println(ans);
    }
}
