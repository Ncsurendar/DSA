package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverLappingIntervals {

    public static List<int[]> mergeOverlappingIntervals(List<int[]> intervals)
    {
        intervals.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(interval);
            }
            else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        List<int[]> intervals = Arrays.asList(
                new int[]{1, 3},
                new int[]{8, 10},
                new int[]{2, 6},
                new int[]{15, 18}
        );
        List<int[]> result = mergeOverlappingIntervals(intervals);
        System.out.print("The merged intervals are: \n");
        for (int[] interval: result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
        System.out.println();
    }
}
