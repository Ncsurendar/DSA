package StackandQueues;

import java.util.Stack;

public class PreviousSmallerElement {

    public static int[] prevSmaller(int[] arr)
    {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++)
        {
            while(!st.isEmpty() && st.peek() >= arr[i]) st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] ans = prevSmaller(arr);
        for (int it : ans) {
            System.out.print(it + " ");
        }
    }
}
