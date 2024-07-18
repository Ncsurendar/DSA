package StackandQueues;

import java.util.Stack;

public class SumOfSubArraysRanges {

    public static long subArrayRanges(int[] nums)
    {
        int n = nums.length;
        long sumMax = 0, sumMin = 0;

        Stack<Integer> st = new Stack<>();
        // Find the sum of ranges using the maximums
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] < nums[i])) {
                int j = st.pop();
                int k = st.isEmpty() ? -1 : st.peek();
                sumMax += (long) nums[j] * (i - j) * (j - k);
            }
            st.push(i);
        }

        st.clear();

        // Find the sum of ranges using the minimums
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] > nums[i])) {
                int j = st.pop();
                int k = st.isEmpty() ? -1 : st.peek();
                sumMin += (long) nums[j] * (i - j) * (j - k);
            }
            st.push(i);
        }

        return sumMax - sumMin;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        long result = subArrayRanges(nums);
        System.out.println("Sum of all subarray ranges: " + result);
    }
}
