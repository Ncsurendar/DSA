package DynamicProgramming;

public class L56CountSquareSubmatricesWithAllOnes {

    static int countSquares(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for(int j=0; j<m; j++) dp[0][j] = matrix[0][j];
        for(int i=0; i<n; i++) dp[i][0] = matrix[i][0];

        for(int i=1; i<n; i++)
        {
            for(int j=1; j<m; j++)
            {
                if(matrix[i][j] == 0) dp[i][j] = 0;
                else
                {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }

        int sum = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                sum += dp[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 1, 1}, {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        int ans = countSquares(arr);
        System.out.println(ans);
    }
}
