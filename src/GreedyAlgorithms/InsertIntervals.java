package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && (intervals[i][1] < newInterval[0])) {
            res.add(intervals[i++]);
        }
        while (i < intervals.length && (intervals[i][0] <= newInterval[1])) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }
        res.add(newInterval);
        while (i < intervals.length) {
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval= {4, 8};

        int[][] result1 = insert(intervals, newInterval);
        System.out.println("Result:");
        printIntervals(result1);
    }

    private static void printIntervals(int[][] intervals)
    {
        for (int[] interval : intervals)
        {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }
}
