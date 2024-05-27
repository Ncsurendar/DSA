package BinarySearch;

public class PeakIndexOfMountainArray {
    public static void main(String[] args) {
        int [] arr = {0,10,5,2};
        int ans = -1;
        int n = arr.length;

        if(n == 1) ans = 0;
        if(arr[0] > arr[1]) ans = 1;
        if(arr[n-1] > arr[n-2]) ans = n-1;

        int low = 1, high = n-2;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) ans = mid;
            else if(arr[mid] > arr[mid-1])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        System.out.println(ans);

    }
}
