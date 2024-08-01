package DynamicProgramming.L1;

import java.util.Arrays;

public class IntroductionToDP {

    static int f(int n, int[] dp)   // Using Memoization Technique(Top To Down) where storing all the values in the array dp.
    {
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = f(n-1,dp) + f(n-2, dp);          // TC : O(N) and SC: O(N) + O(N) Recursive stack + Array
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(f(n,dp));

        // Method 2 : Tabulation
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);

        // Method 3 : Optimize the SC from method 2
        int prev2 = 0;
        int prev = 1;
        for(int i=2; i<=n; i++)
        {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        System.out.println(prev);
    }
}
