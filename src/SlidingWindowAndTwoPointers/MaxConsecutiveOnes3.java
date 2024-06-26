package SlidingWindowAndTwoPointers;

public class MaxConsecutiveOnes3 {

    static int longestOnes(int[] arr, int k)
    {
        int left = 0, right = 0, maxLen = 0, zeros = 0;
        while(right < arr.length)
        {
            if(arr[right] == 0) zeros++;
            if(zeros <= k)
            {
                int len = right - left + 1;
                maxLen = Math.max(maxLen,len);
            }
            if(zeros > k)
            {
                if(arr[left] == 0) zeros--;
                left++;
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int ans = longestOnes(arr,k);
        System.out.println(ans);
    }
}
