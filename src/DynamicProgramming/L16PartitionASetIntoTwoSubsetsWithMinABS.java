package DynamicProgramming;

public class L16PartitionASetIntoTwoSubsetsWithMinABS {

    static int minimumDifference(int[] nums)
    {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int total = 0;
        for(int num : nums) total += num;


        int k = total;
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0; i<n; i++) dp[i][0] = true;
        if(nums[0] <= k) dp[0][nums[0]] = true;

        for(int ind=1; ind<n; ind++)
        {
            for(int target=1; target<=k; target++)
            {
                boolean notTake = dp[ind-1][target];
                boolean Take = false;
                if(nums[ind] <= target) Take = dp[ind-1][target - nums[ind]];
                dp[ind][target] = Take || notTake;
            }
        }

        int mini = Integer.MAX_VALUE;
        for(int s1 = 0; s1 <= total/2; s1++)
        {
            if(dp[n - 1][s1])
            {
                mini = Math.min(mini, Math.abs(s1 - (total - s1)));
            }
        }

        return mini;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 9};
        int result = minimumDifference(nums);
        System.out.println("The minimum difference between two sets is: " + result);
    }
}
