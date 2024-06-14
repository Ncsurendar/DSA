package Recurssion;

import java.util.Stack;

public class SortAStack {

    public static Stack<Integer> sort(Stack<Integer> s)
    {
        if(s.isEmpty()) return s;
        int temp = s.pop();
        sort(s);
        helper(s,temp);
        return s;
    }

    static void helper(Stack<Integer> s, int temp)
    {
        if(s.isEmpty() || s.peek() < temp)
        {
            s.push(temp);
            return;
        }
        int element = s.pop();
        helper(s,temp);
        s.push(element);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        System.out.println("Original stack: " + stack);
        Stack<Integer> sortedStack = sort(stack);
        System.out.println("Sorted stack: " + sortedStack);
    }
}
