package DynamicProgramming;

public class L08UniquePaths {

    static int countWays(int m, int n)
    {
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else
                {
                    int up = 0, left = 0;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(countWays(m, n));
    }
}
