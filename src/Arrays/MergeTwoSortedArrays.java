package Arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int [] arr1 = {1,3,5,7};
        int [] arr2 = {0,2,4,6,8};
        int len1 = arr1.length;
        int len2 = arr2.length;
        int left = len1-1;
        int right = 0;
        while(left >= 0 && right < len2)
        {
            if(arr1[left] > arr2[right])
            {
                arr1[left] = arr1[left]+arr2[right]-(arr2[right] = arr1[left]);
                left--;
                right++;
            }
            else
            {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i:arr1)
        {
            System.out.print(i+" ");
        }
        for(int j:arr2)
        {
            System.out.print(j+" ");
        }
    }
}
