package StackandQueues;

import java.util.Stack;

public class NextGreaterElementCircularVersion {

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if (i < n) {
                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
            }
            stack.push(nums[i % n]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        int[] result = nextGreaterElements(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
