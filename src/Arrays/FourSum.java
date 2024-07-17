package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int [] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++)
        {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length; j++)
            {
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int k = j+1;
                int l = nums.length-1;
                while(k < l)
                {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum > target) l--;
                    else if(sum < target) k++;
                    else
                    {
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }

        for(int i=0; i<=ans.size(); i++)
        {
            for(int j=0; j<=ans.size(); j++)
            {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
