package Arrays;
import java.util.HashMap;


public class TwoSum {
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        int [] arr = new int [2];
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i=0; i<nums.length; i++)
        {
            int required = target - nums[i];
            if(mp.containsKey(required))
            {
                arr[0] = mp.get(required);
                arr[1] = i;
            }
            mp.put(nums[i],i);
        }
        for(int i:arr)
        {
            System.out.println(i);
        }
    }
}
