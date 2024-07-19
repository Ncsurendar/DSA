package StackandQueues;

import java.util.Stack;

public class MaximalRectangle {

    static int LargestRectangleInAHistogram(int[] arr)
    {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0, n = arr.length;

        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, (nse - pse - 1) * arr[element]);
            }
            st.push(i);
        }

        while(!st.isEmpty())
        {
            int element = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, (nse - pse - 1) * arr[element]);
        }

        return maxArea;
    }

    static int maximalRectangle(char[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int MaxSum = 0;
        int[][] prefixSum = new int[n][m];

        for(int j=0; j<m; j++)
        {
            int count = 0;
            for(int i=0; i<n; i++)
            {
                if(matrix[i][j] == '1') count++;
                else count = 0;
                prefixSum[i][j] = count;
            }
        }

        for(int i=0; i<n; i++)
        {
            MaxSum = Math.max(MaxSum, LargestRectangleInAHistogram(prefixSum[i]));
        }

        return MaxSum;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        int result = maximalRectangle(matrix);
        System.out.println("The maximal rectangle area is: " + result);
    }
}
