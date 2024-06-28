package SlidingWindowAndTwoPointers;

public class BinarySubarrayWithSum {

    static int fun(int[] arr, int goal)
    {
        if(goal < 0) return 0;
        int left = 0, right = 0, sum = 0, count = 0;
        while(right < arr.length)
        {
            sum += arr[right];
            while(sum > goal)
            {
                sum = sum - arr[left];
                left++;
            }
            count = count + (right - left + 1);
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        int goal = 2;
        int ans = fun(arr, goal) - fun(arr, goal-1);
        System.out.println(ans);
    }
}
