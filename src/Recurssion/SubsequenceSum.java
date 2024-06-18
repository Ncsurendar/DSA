package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceSum {

    static void findSubsequences(int[]arr, int index, List<Integer> current, int sum, int target)
    {
        if(index == arr.length)
        {
            if(sum == target)
            {
                System.out.println(current);
            }
            return;
        }

        current.add(arr[index]);
        findSubsequences(arr,index+1, current, sum+arr[index], target);
        current.remove(current.size()-1);

        findSubsequences(arr, index+1, current, sum, target);
    }

    public static void printSubsequencesWithSum(int[] arr, int target)
    {
        List<Integer> current = new ArrayList<>();
        findSubsequences(arr, 0, current, 0, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int sum = 2;
        printSubsequencesWithSum(arr, sum);
    }
}
