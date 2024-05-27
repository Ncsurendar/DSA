package BinarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int [] arr = {1,2,4,7};
        int target = 2;
        int left = 0, right = arr.length-1;
        int index = right;

        while(left <= right)
        {
            int mid = (left + right)/2;
            if(arr[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                index = mid;
                right = mid - 1;
            }

        }
        System.out.println(index);

    }
}
