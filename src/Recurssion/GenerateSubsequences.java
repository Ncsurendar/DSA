package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsequences {

    public static void generateSubsequences(int[] arr, int index, List<Integer> current)
    {
        if(index == arr.length)
        {
            System.out.println(current);
            return;
        }

        current.add(arr[index]);
        generateSubsequences(arr,index+1,current);
        current.remove(current.size()-1);

        generateSubsequences(arr,index+1, current);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        List<Integer> current = new ArrayList<>();
        generateSubsequences(arr, 0, current);
    }
}
