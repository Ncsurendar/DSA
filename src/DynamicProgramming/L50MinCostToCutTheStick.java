package DynamicProgramming;
import java.util.*;

public class L50MinCostToCutTheStick {

    static int helper(int i, int j, List<Integer> cuts, int[][] dp)
    {
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int ind = i; ind<=j; ind++)
        {
            int cost = cuts.get(j+1) - cuts.get(i-1) + helper(i, ind-1, cuts, dp) + helper(ind+1, j, cuts, dp);
            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }

    static int minCost(int n, int[] cut)
    {
        int c = cut.length;
        List<Integer> cuts = new ArrayList<>();
        cuts.add(0);
        cuts.add(n);
        for(int it : cut) cuts.add(it);

        Collections.sort(cuts);
        int[][] dp = new int[c+1][c+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(1, c, cuts, dp);
    }

    public static void main(String[] args) {
        int n = 9;
        int[] cut = {5,6,1,4,2};
        int total = minCost(n, cut);
        System.out.println(total);
    }
}
