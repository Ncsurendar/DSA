package StackandQueues;

public class TrappingRainWater {

    static int trap(int[] arr)
    {
        int n = arr.length;
        int l = 0, r = n-1;
        int lmax = 0, rmax = 0, total = 0;
        for(int i=0; i<n; i++)
        {
            if(arr[l] <= arr[r])
            {
                if(arr[l] > lmax)
                {
                    lmax = arr[l];
                }
                else
                {
                    total += lmax - arr[l];
                }
                l++;
            }
            else
            {
                if(arr[r] > rmax)
                {
                    rmax = arr[r];
                }
                else
                {
                    total += rmax - arr[r];
                }
                r--;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The total water stored is " + trap(arr));
    }
}
