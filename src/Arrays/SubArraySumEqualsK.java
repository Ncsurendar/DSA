package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int [] nums= {1,1,1};
        int k = 2;

        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0, count = 0;
        mp.put(0,1);
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i];
            int remove = sum - k;
            count += mp.getOrDefault(remove, 0);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }
}
