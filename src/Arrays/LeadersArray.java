package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersArray {
    public static void main(String[] args) {
        int [] arr = {10, 22, 12, 3, 0, 6};
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for(int i=arr.length-1; i>=0; i--)
        {
            if(arr[i] > max)
            {
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        for(int a:ans)
            System.out.println(a);

    }
}
