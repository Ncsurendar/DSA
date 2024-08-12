package DynamicProgramming;

import java.util.Arrays;

public class L34WildcardMatching {

    static int helper(String S1, String S2, int i, int j, int[][] dp)
    {
        if (i < 0 && j < 0) return 1;
        if (j < 0) return 0;
        if (i < 0)
        {
            for (int jj = 0; jj <= j; jj++)
            {
                if (S2.charAt(jj) != '*') return 0;
            }
            return 1;
        }

        if (dp[i][j] != -1) return dp[i][j];
        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?') return dp[i][j] = helper(S1, S2, i - 1, j - 1, dp);
        else
        {
            if (S1.charAt(i) == '*')
            {
                return dp[i][j] = (helper(S1, S2, i - 1, j, dp) == 1 || helper(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
            }
            else return 0;
        }
    }

    static int wildcardMatching(String S1, String S2)
    {
        int n = S1.length();
        int m = S2.length();

        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(S1, S2, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        String S1 = "ab*cd";
        String S2 = "abdefcd";

        if (wildcardMatching(S1, S2) == 1)
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");
    }
}
