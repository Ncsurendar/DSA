package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverLappingIntervals {

    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr)
    {
        int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1))
            {
                ans.add(Arrays.asList(arr[i][0],arr[i][1]));
            }
            else
            {
                ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1), arr[i][1]));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = mergeOverlappingIntervals(arr);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }
}
