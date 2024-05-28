package BinarySearch;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int [] arr = {3,6,7,11};
        int h = 8;

        int maxi = 0;
        for(int i=0; i<arr.length; i++)
        {
            maxi = Math.max(maxi,arr[i]);
        }

        int low = 1, high = maxi;
        while(low <= high)
        {
            int mid = (low + high)/2;
            int ans = Calculate(arr,mid);
            if(ans <= h)
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

    public static int Calculate(int[] arr, int hour)
    {
        int sum = 0;
        for(int i=0; i<arr.length; i++)
        {
            sum += Math.ceil((double)(arr[i])/(double)(hour));
        }
        return sum;
    }
}
