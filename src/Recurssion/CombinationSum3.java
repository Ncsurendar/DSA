package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    static void helper(int index, int[] arr, int k, int target, List<List<Integer>> ans, List<Integer> current)
    {
        if(target == 0 && current.size() == k)
        {
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=index; i<arr.length; i++)
        {
            current.add(arr[i]);
            helper(i+1, arr, k, target-arr[i], ans, current);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> ans = new ArrayList<>();
        int [] numbers = {1,2,3,4,5,6,7,8,9};
        helper(0, numbers, k, n, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        List<List<Integer>> result = combinationSum3(k, n);
        for (List<Integer> combination : result)
        {
            System.out.println(combination);
        }
    }
}
