package StackandQueues;

import java.util.*;

public class SlidingWindowMaximum {

    static int[] maxSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++)
        {
            if(!dq.isEmpty() && dq.peekFirst() <= i - k)
            {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
            {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k - 1) list.add(nums[dq.peekFirst()]);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
