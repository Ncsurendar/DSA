package DynamicProgramming;

import java.util.Arrays;

public class L33EditDistance {

    static int helper(int i, int j, String word1, String word2, int[][] dp)
    {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) return dp[i][j] = helper(i-1, j-1, word1, word2, dp);
        return dp[i][j] = Math.min(1 + helper(i-1, j, word1, word2, dp), Math.min(1 + helper(i, j-1, word1, word2, dp), 1 + helper(i-1, j-1, word1, word2, dp)));
    }

    static int editDistance(String word1, String word2)
    {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(n-1, m-1, word1, word2, dp);
    }


    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("The minimum number of operations required is: " +
                editDistance(s1, s2));
    }
}
