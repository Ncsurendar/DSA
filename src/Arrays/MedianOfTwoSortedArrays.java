package Arrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int [] nums1 = {1,2};
        int [] nums2 = {3,4};
        int n = nums1.length;
        int m = nums2.length;
        int [] arr = new int[n+m];
        for(int i=0; i<n; i++)
        {
            arr[i] = nums1[i];
        }
        for(int i=0; i<m; i++)
        {
            arr[i] = nums2[i];
        }
        Arrays.sort(arr);
        int len = arr.length;
        if(len % 2 == 1)
        {
            System.out.println((double)arr[len/2]+" ");
        }
        else
        {
            int mid1 = arr[len / 2 - 1];
            int mid2 = arr[len / 2];
            System.out.println(((double) mid1 + (double) mid2)/ 2.0);
        }

    }
}
