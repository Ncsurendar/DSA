package BinarySearch;

public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = {3,4,5,1,2};
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int low = 0, high = n-1;

        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid] >= nums[low])
            {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }
            else
            {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }

        System.out.println(ans);

    }
}
