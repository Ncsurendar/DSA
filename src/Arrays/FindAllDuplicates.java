package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

    public static void main(String[] args) {
        int [] arr = {4,3,2,7,8,2,3,1};
        List<Integer> ans = new ArrayList<>();
        for(int i:arr)
        {
            i = Math.abs(i);
            if(arr[i-1] > 0) arr[i-1] *= -1;
            else ans.add(i);
        }

        for(int j:ans)
        {
            System.out.println(j);
        }

    }
}
