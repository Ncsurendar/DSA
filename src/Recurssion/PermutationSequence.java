package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public static String permutationSequence(int n, int k)
    {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for(int i=1; i<n; i++)
        {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k-1;
        String ans = "";

        while(true)
        {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);
            if(numbers.size() == 0) break;
            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        System.out.println(permutationSequence(n,k));
    }
}
