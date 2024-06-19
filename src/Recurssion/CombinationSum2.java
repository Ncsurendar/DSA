package Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    private static void helper(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> current)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=index; i<arr.length; i++)
        {
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            current.add(arr[i]);
            helper(i+1, arr, target-arr[i], ans, current);
            current.remove(current.size() - 1);
        }
    }

    public static List < List < Integer >> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int v[]={10,1,2,7,6,1,5};
        List <List< Integer >> comb = combinationSum2(v, 8);
        System.out.println(comb.toString().replace(",", " "));
    }
}
