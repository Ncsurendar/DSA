package Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    static void helper(int index, int[] arr, List<List<Integer>> ans, List<Integer> current)
    {
        ans.add(new ArrayList<>(current));

        for(int i=index; i<arr.length; i++)
        {
            if(i != index && arr[i] == arr[i-1]) continue;
            current.add(arr[i]);
            helper(i+1, arr, ans, current);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
