package SlidingWindowAndTwoPointers;

public class MaxPointsToObtainCards {

    static int maxScore(int[] arr, int k)
    {
        int leftSum = 0, rightSum = 0, maxSum = 0;
        int n = arr.length;
        for(int i=0; i<k; i++)
        {
            leftSum = leftSum + arr[i];
        }
        maxSum = leftSum;
        int rightIndex = n-1;

        for(int i=k-1; i>=0; i--)
        {
            leftSum = leftSum - arr[i];
            rightSum = rightSum + arr[rightIndex];
            maxSum = Math.max(maxSum, leftSum + rightSum);
            rightIndex = rightIndex - 1;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1};
        int k = 3;
        int ans = maxScore(arr,k);
        System.out.println(ans);
    }
}
