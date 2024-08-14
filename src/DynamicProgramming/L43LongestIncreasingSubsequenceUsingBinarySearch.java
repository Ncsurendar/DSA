package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class L43LongestIncreasingSubsequenceUsingBinarySearch {

    static int longestIncreasingSubsequence(int[] arr, int n)
    {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        int len = 1;

        for(int i=1; i<n; i++)
        {
            if(temp.get(temp.size() - 1) < arr[i])
            {
                temp.add(arr[i]);
                len++;
            }
            else
            {
                int ind = binarySearch(temp, arr[i]);
                temp.set(ind, arr[i]);
            }
        }

        return len;
    }

    static int binarySearch(List<Integer> temp, int target)
    {
        int left = 0;
        int right = temp.size() - 1;

        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(temp.get(mid) == target) return mid;
            else if(temp.get(mid) < target) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr, n));
    }
}
