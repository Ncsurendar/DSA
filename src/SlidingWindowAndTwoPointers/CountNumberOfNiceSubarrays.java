package SlidingWindowAndTwoPointers;

public class CountNumberOfNiceSubarrays {

    static int fun(int[] arr, int k)
    {
        if(k < 0) return 0;
        int left = 0, right = 0, sum = 0, count = 0;
        while(right < arr.length)
        {
            sum += arr[right] % 2;
            while(sum > k)
            {
                sum = sum - arr[left] % 2;
                left++;
            }
            count = count + (right - left + 1);
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1};
        int k = 3;
        int ans = fun(arr, k) - fun(arr, k-1);
        System.out.println(ans);
    }
}
