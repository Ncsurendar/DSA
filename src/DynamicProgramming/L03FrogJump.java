package DynamicProgramming;

public class L03FrogJump {
    public static void main(String[] args) {
        int[] height ={30,10,60,10,60,50};
        int n = height.length;

        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1; i<n; i++)
        {
            int fs = dp[i-1] + Math.abs(height[i-1] - height[i]);
            int ss = i > 1 ? dp[i-2] + Math.abs(height[i-2] - height[i]) : Integer.MAX_VALUE;
            dp[i] = Math.min(fs, ss);
        }

        System.out.println(dp[n-1]);
    }
}
