package DynamicProgramming;

public class L10MinimumPathSum {

    static int minSumPath(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(i == 0  && j == 0) dp[i][j] = grid[0][0];
                else
                {
                    int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
                    if(i > 0) up = grid[i][j] + dp[i-1][j];
                    if(j > 0) left = grid[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minSumPath(matrix));
    }
}
