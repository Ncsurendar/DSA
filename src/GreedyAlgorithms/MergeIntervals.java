package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] mergeOverlappingIntervals(int[][] arr)
    {
        List<int[]> ans = new ArrayList<>();

        if(arr.length == 0) return ans.toArray(new int[0][]);
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        int start = arr[0][0];
        int end = arr[0][1];

        for(int[] i : arr)
        {
            if(i[0] <= end)
            {
                end = Math.max(end, i[1]);
            }
            else
            {
                ans.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] ans = mergeOverlappingIntervals(arr);
        System.out.print("The merged intervals are: \n");
        for (int[] interval : ans) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }
}
