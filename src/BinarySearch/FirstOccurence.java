package BinarySearch;

public class FirstOccurence {
    public static void main(String[] args) {
        int [] arr = {2,8,8,8,8,8,11,13};
        int target = 11;
        int n = arr.length;
        int low = 0 ,high = n-1;
        int start = -1;

        while(low <= high)
        {
            int mid = (low + high)/2;
            if(arr[mid] == target)
            {
                start = mid;
                high = mid - 1;
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

        System.out.println(start);
    }
}
