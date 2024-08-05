package DynamicProgramming;

import java.util.*;

public class L11MinimumPathSumInTriangular {

    static int minimumTotal(List<List<Integer>> triangle)
    {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int j=0; j<n; j++)
        {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--)
        {
            for(int j=i; j>=0; j--)
            {
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        int result = minimumTotal(triangle);
        System.out.println("The minimum path sum is: " + result);
    }
}
