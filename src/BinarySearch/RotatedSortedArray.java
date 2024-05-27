package BinarySearch;

public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int ans = -1;
        int target = 1;
        int n = arr.length;
        int low = 0, high = n-1;

        while(low <= high)
        {
            int mid = (low + high)/2;
            if(arr[mid] == target) ans = mid;
            // figure out which side is sorted if left is sorted:
            if(arr[mid] >= arr[low])
            {
                if(arr[low] <= target  && target <= arr[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            // else if right side is sorted:
            else
            {
                if(arr[mid] <= target && target <= arr[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }

        System.out.println(ans);
    }
}
