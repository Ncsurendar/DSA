package StackandQueues;

import java.util.Stack;

public class SumOfSubArraysMinimums {

    public static int sumSubarrayMins(int[] arr)
    {
        final int MOD = 1000000007;
        int n = arr.length;
        long res = 0;

        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        // Find the nearest smaller element on the left for each element
        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]) st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Find the nearest smaller element on the right for each element
        for(int i=n-1; i>=0; i--)
        {
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for(int i=0; i<n; i++)
        {
            res = (res + (long) arr[i] * (i - left[i]) * (right[i] - i)) % MOD;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int result = sumSubarrayMins(arr);
        System.out.println("Sum of subArray minimums for arr: " + result);
    }
}
