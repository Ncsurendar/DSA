package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfArray {

    static void helper(int[] arr, List<List<Integer>> ans, List<Integer> current, boolean[] freq)
    {
        if(current.size() == arr.length)
        {
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<arr.length; i++)
        {
            if(!freq[i])
            {
                freq[i] = true;
                current.add(arr[i]);
                helper(arr, ans, current, freq);
                current.remove(current.size() - 1);
                freq[i] = false;
            }
        }
    }

    public static List<List<Integer>> permute(int[] arr)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean freq[] = new boolean[arr.length];
        helper(arr, ans, current, freq);
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        List<List<Integer>> permutations = permute(arr);
        for (List<Integer> permutation : permutations)
        {
            System.out.println(permutation);
        }
    }
}
