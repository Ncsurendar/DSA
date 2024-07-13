package GreedyAlgorithms;

import java.util.Arrays;

public class NonOverLappingIntervals {

    static int eraseOverlapIntervals(int[][] intervals)
    {
        int count = 0;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int lastEndTime = intervals[0][1];

        for(int i=1; i<intervals.length; i++)
        {
            if(lastEndTime > intervals[i][0]) count++;
            else lastEndTime = intervals[i][1];
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {2,3},{3,4},{1,3}};
        int ans = eraseOverlapIntervals(intervals);
        System.out.println(ans);
    }
}
