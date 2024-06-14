package Recurssion;

import java.util.Stack;

public class ReverseAStack {

    static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty()) return;
        int temp = s.pop();
        reverse(s);
        helper(s,temp);
    }

    static void helper(Stack<Integer> s, int temp)
    {
        if(s.isEmpty())
        {
            s.push(temp);
            return;
        }
        int ele = s.pop();
        helper(s,temp);
        s.push(ele);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Original Stack: " + stack);
        reverse(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}
