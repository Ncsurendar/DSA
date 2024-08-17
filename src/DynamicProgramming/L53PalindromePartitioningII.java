package DynamicProgramming;
import java.util.*;

public class L53PalindromePartitioningII {

    static boolean isPalindrome(String s, int start, int end)
    {
        while(start <= end)
        {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    static int minCut(String s)
    {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[n] = 0;

        for(int i=n-1; i>=0; i--)
        {
            int mini = Integer.MAX_VALUE;
            for(int j=i; j<n; j++)
            {
                if(isPalindrome(s, i, j))
                {
                    int cost = 1 + dp[j+1];
                    mini = Math.min(mini, cost);
                }
            }

            dp[i] = mini;
        }

        return dp[0] - 1;       // To Avoid the last cut that is made
    }

    public static void main(String[] args) {
        String s = "aab";
        int ans = minCut(s);
        System.out.println(ans);
    }
}
