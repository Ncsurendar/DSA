package StackandQueues;

import java.util.Stack;

public class LargestRectangleInAHistogram {

    static int largestRectangleArea(int[] arr)
    {
        int n = arr.length, MaxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                MaxArea = Math.max(MaxArea, arr[element] * (nse - pse - 1));
            }
            st.push(i);
        }

        while(!st.isEmpty())
        {
            int element = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            MaxArea = Math.max(MaxArea, arr[element] * (nse - pse - 1));
        }

        return MaxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = largestRectangleArea(heights);
        System.out.println("The largest rectangle area is: " + result);
    }
}
