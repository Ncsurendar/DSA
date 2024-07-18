package StackandQueues;

import java.util.Stack;

class MinStack {
    Stack<Long> st = new Stack<>();
    Long mini;

    public MinStack() {
        mini = Long.MAX_VALUE;
    }

    public void push(int value) {
        Long val = Long.valueOf(value);
        if(st.isEmpty())
        {
            mini = val;
            st.push(val);
        }
        else
        {
            if(val < mini)
            {
                st.push(2 * val - mini);
                mini = val;
            }
            else
            {
                st.push(val);
            }
        }
    }

    public void pop() {
        if(st.isEmpty()) return;
        Long val = st.pop();
        if(val < mini)
        {
            mini = 2 * mini - val;
        }
    }

    public int top() {
        Long val = st.peek();
        if(val < mini)
        {
            return mini.intValue();
        }
        return val.intValue();
    }

    public int getMin() {
        return mini.intValue();
    }
}

public class ImplMinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Minimum: " + minStack.getMin());  // Outputs -3

        minStack.pop();

        System.out.println("Top: " + minStack.top());         // Outputs 0
        System.out.println("Minimum: " + minStack.getMin());  // Outputs -2

        minStack.push(-4);

        System.out.println("Minimum: " + minStack.getMin());  // Outputs -4
        System.out.println("Top: " + minStack.top());         // Outputs -4

        minStack.pop();

        System.out.println("Top: " + minStack.top());         // Outputs 0
        System.out.println("Minimum: " + minStack.getMin());  // Outputs -2
    }
}
