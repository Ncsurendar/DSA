package DynamicProgramming;

public class L5HouseRobber {

    static int solve(int n, int[] arr)
    {
        int[] dp = new int[n];
        return solve(n, arr, dp);
    }

    static int solve(int n, int[] arr, int[] dp)
    {
        dp[0] = arr[0];
        for(int i=1; i<n; i++)
        {
            int pick = arr[i];
            if(i > 1) pick += dp[i-2];
            int notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        int n = arr.length;
        int result = solve(n, arr);
        System.out.println(result);
    }
}
