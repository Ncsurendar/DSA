package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class PermuteArray {

    static void helper(int index, int[] arr, List<List<Integer>> ans)
    {
        if(index == arr.length)
        {
            List<Integer> current = new ArrayList<>();
            for(int i=0; i<arr.length; i++)
            {
                current.add(arr[i]);
            }
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=index; i<arr.length; i++)
        {
            swap(i, index, arr);
            helper(index+1, arr, ans);
            swap(i, index, arr);
        }
    }

    static void swap(int i, int j, int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static List<List<Integer>> permute(int [] arr)
    {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, arr, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> permutations = permute(arr);
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
