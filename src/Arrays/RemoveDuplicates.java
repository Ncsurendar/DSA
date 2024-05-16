package Arrays;

import java.util.HashSet;

public class RemoveDuplicates {

    static int removeDuplicate(int [] arr)
    {
        HashSet <Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++)
        {
            set.add(arr[i]);
        }
        int k = set.size();
        int j=0;
        for(int x:set)
        {
            arr[j++] = x;
        }
        return k;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,2,2,2,3,3};
        int k = removeDuplicate2(arr);
        for(int i=0; i<k; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    static int removeDuplicate2(int [] arr)
    {
        int i=0;
        for(int j=1; j<arr.length; j++)
        {
            if(arr[i] != arr[j])
            {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
}
