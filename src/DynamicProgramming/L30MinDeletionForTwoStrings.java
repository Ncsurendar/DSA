package DynamicProgramming;

public class L30MinDeletionForTwoStrings {

    static int canYouMake(String text1, String text2)
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

        int lcs = dp[n][m];
        int deletions = n - lcs;
        int insertions = m - lcs;

        return deletions + insertions;
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "anc";
        System.out.println("The Minimum operations required to convert str1 to str2: "
                + canYouMake(str1, str2));
    }
}
