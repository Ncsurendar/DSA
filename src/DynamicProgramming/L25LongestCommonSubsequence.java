package DynamicProgramming;

public class L25LongestCommonSubsequence {

    static int lcs(String text1, String text2)
    {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int j=0; j<=m; j++) dp[0][j] = 0;
        for(int i=0; i<=n; i++) dp[i][0] = 0;

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";

        System.out.println("The Length of Longest Common Subsequence is " + lcs(s1, s2));
    }
}