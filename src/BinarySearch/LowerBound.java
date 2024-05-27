package BinarySearch;

public class LowerBound {

    public static void main(String[] args) {
        int [] arr = {3,5,8,15,19};
        int target = 9, n = 5;
        int low = 0, high = n-1;
        int ans = n;

        while(low <= high)
        {
            int mid = (low + high)/2;
            if(arr[mid] >= target)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }

        }

        System.out.println(ans);

    }
}
