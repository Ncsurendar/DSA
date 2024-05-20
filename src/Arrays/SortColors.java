package Arrays;

//This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.
//arr[0….low-1] contains 0, arr[low….mid-1] contains 1, arr[high+1….n-1] contains 2.
// The middle part i.e. arr[mid….high] is the unsorted segment.

//First, we will run a loop that will continue until mid <= high.
// If arr[mid] == 0, we will swap arr[low] and arr[mid] and will increment both low and mid. Now the subarray from index 0 to (low-1) only contains 0.
// If arr[mid] == 1, we will just increment the mid pointer and then the index (mid-1) will point to 1 as it should according to the rules.
// If arr[mid] == 2, we will swap arr[mid] and arr[high] and will decrement high. Now the subarray from index high+1 to (n-1) only contains 2.
// In this step, we will do nothing to the mid-pointer as even after swapping, the subarray from mid to high(after decrementing high) might be unsorted. So, we will check the value of mid again in the next iteration.


public class SortColors {
    public static void main(String[] args) {
        int [] arr = {0,1,2,0,1,2,1,2,0,0,0,1};
        int low = 0,mid = 0, high = arr.length-1;
        while(mid <= high)
        {
            if(arr[mid] == 0)
            {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] == 1)
            {
                mid++;
            }
            else
            {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }

        for(int i:arr)
        {
            System.out.print(i+" ");
        }
    }
}
