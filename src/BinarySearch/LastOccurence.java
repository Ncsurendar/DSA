package BinarySearch;

public class LastOccurence {
    public static void main(String[] args) {
        int [] arr = {2,8,8,8,8,8,11,13};
        int target = 8;
        int n = arr.length;
        int low = 0 ,high = n-1;
        int last = -1;

        while(low <= high)
        {
            int mid = (low + high)/2;
            if(arr[mid] == target)
            {
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        System.out.println(last);
    }
}
