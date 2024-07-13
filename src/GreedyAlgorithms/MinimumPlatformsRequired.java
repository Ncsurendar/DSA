package GreedyAlgorithms;

import java.util.Arrays;

public class MinimumPlatformsRequired {

    static int findPlatform(int[] arr, int[] dep, int n)
    {
        int count = 0, maxCount = 0;
        int i = 0, j = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);

        while(i < n)
        {
            if(arr[i] <= dep[j])
            {
                count++;
                i += 1;
            }
            else
            {
                count -= 1;
                j += 1;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr ={900,945,955,1100,1500,1800};
        int[] dep={920,1200,1130,1150,1900,2000};
        int n=arr.length;
        int totalCount=findPlatform(arr,dep,n);
        System.out.println("Minimum number of Platforms required "+totalCount);
    }
}
