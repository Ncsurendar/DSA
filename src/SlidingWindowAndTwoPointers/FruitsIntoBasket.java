package SlidingWindowAndTwoPointers;

import java.util.HashMap;

public class FruitsIntoBasket {

    static int totalFruits(int[] fruits, int n)
    {
        int left = 0, right = 0, maxLen = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        while(right < fruits.length)
        {
            mp.put(fruits[right], mp.getOrDefault(fruits[right], 0) + 1);
            while(mp.size() > 2)
            {
                mp.put(fruits[left], mp.get(fruits[left]) - 1);
                if(mp.get(fruits[left]) == 0) mp.remove(fruits[left]);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] fruits = {0, 1, 2, 2, 2, 2};
        int n = 6;
        int ans = totalFruits(fruits, n);
        System.out.println(ans);
    }
}
