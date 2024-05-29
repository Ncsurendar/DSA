package BinarySearch;

public class CapacityToShipWithinDays {

    public static int fun(int[] arr, int cap)
    {
        int days = 1, load = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(load + arr[i] > cap)
            {
                days += 1;
                load = arr[i];
            }
            else
            {
                load += arr[i];
            }
        }
        return days;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        int maxi = 0, sum = 0;
        for(int i=0; i<arr.length; i++)
        {
            maxi = Math.max(maxi,arr[i]);
            sum += arr[i];
        }

        int low = maxi, high = sum;
        while(low <= high)
        {
            int mid = (low + high)/2;
            int daysRequired = fun(arr,mid);
            if(daysRequired <= days)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
}
