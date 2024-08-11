package DynamicProgramming;

public class L32DistinctSubsequences {

    static int subsequenceCounting(String s1, String s2, int n, int m)
    {
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) dp[i][0] = 1;
        for(int i=1; i<=m; i++) dp[0][i] = 0;

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }


    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        System.out.println("The Count of Distinct Subsequences is " +
                subsequenceCounting(s1, s2, s1.length(), s2.length()));
    }
}
