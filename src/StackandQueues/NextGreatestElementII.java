package StackandQueues;

import java.util.Stack;

public class NextGreatestElementII {

    static int[] nextGreaterElements(int[] nums)
    {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--)
        {
            while(!st.isEmpty() && st.peek() <= nums[i]) st.pop();
            if(st.isEmpty()) result[i] = -1;
            else result[i] = st.peek();
            st.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] result = nextGreaterElements(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
