package GreedyAlgorithms;

public class JumpGameII {

    public static int jumps(int[] arr)
    {
        int jumps = 0, left = 0, right = 0;
        int n = arr.length;
        while(right < n-1)
        {
            int farthest = 0;
            for(int i=left; i<=right; i++)
            {
                farthest = Math.max(farthest, i + arr[i]);
            }
            jumps++;
            left = right + 1;
            right = farthest;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int ans = jumps(arr);
        System.out.println(ans);
    }
}
