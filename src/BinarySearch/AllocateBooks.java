package BinarySearch;

public class AllocateBooks {

    public static int fun(int[] nums, int pages)
    {
        int students = 1;
        int SumPages = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(SumPages + nums[i] <= pages)
            {
                SumPages += nums[i];
            }
            else
            {
                students += 1;
                SumPages = nums[i];
            }
        }
        return students;
    }

    public static void main(String[] args) {
        int [] nums = {7,2,5,10,8};
        int k = 2;

        int maxi = 0, sum = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i];
            maxi = Math.max(maxi, nums[i]);
        }

        int low = maxi, high = sum;
        while(low <= high)
        {
            int mid = (low + high)/2;
            int numberStudent = fun(nums, mid);
            if(numberStudent > k)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        System.out.println(low);
    }
}
