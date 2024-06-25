package StackandQueues;
import java.util.Stack;

public class ImplementQueueUsingStack {
    public static void main(String args[]) {
        MyQueue q = new MyQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());

    }
}

class MyQueue {
    Stack < Integer > input = new Stack <> ();
    Stack < Integer > output = new Stack <> ();
    public MyQueue() {

    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.empty())
        {
            while (input.empty() == false)
            {
                output.push(input.peek());
                input.pop();
            }
        }
        int x = output.peek();
        output.pop();
        return x;
    }

    public int peek() {
        if (output.empty())
        {
            while (input.empty() == false)
            {
                output.push(input.peek());
                input.pop();
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}
