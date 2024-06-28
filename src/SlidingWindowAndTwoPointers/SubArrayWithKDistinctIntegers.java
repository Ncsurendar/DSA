package SlidingWindowAndTwoPointers;

import java.util.HashMap;

public class SubArrayWithKDistinctIntegers {

    static int fun(int[] arr, int k)
    {
        if(k < 0) return 0;
        int left = 0, right = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(right < arr.length)
        {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while(map.size() > k)
            {
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0) map.remove(arr[left]);
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        int k = 2;
        int ans = fun(arr, k) - fun(arr, k-1);
        System.out.println(ans);
    }
}
