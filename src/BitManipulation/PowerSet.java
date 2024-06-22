package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static List<List<Integer>> generatePowerSet(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int powerSetSize = 1 << n;

        for(int i=0; i<powerSetSize; i++)
        {
            List<Integer> current = new ArrayList<>();
            for(int j=0; j<n; j++)
            {
                if((i & (1 << j)) != 0) current.add(nums[j]);
            }
            ans.add(current);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> powerSet = generatePowerSet(nums);
        System.out.println("Power set:");
        for (List<Integer> subset : powerSet)
        {
            System.out.println(subset);
        }
    }
}
