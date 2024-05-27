package BinarySearch;

public class UpperBound {

    // Smallest index such that arr[mid] > target

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int n = 6, target = 9;
        int low = 0, high = n - 1;
        int ans = n;

        while(low <= high)
        {
            int mid = (high + low)/2;
            if(arr[mid] > target)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }

        }

        System.out.println(ans);
    }
}
