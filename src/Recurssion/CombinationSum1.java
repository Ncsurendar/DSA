package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {

    static void helper(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> current)
    {
        if(index == arr.length)
        {
            if(target == 0)
            {
                ans.add(new ArrayList<>(current));
            }
            return;
        }

        if(arr[index] <= target)
        {
            current.add(arr[index]);
            helper(index, arr, target-arr[index], ans, current);
            current.remove(current.size() - 1);
        }

        helper(index+1, arr, target, ans, current);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println("Combinations that sum to " + target + ": " + result);
    }
}
