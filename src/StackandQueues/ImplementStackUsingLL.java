package StackandQueues;

class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class Stack2{
    Node top;
    int size = 0;
    public void push(int x)
    {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
        size += 1;
    }

    public int pop()
    {
        int poppedData = top.data;
        top = top.next;
        size = size - 1;
        return poppedData;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public int peek()
    {
        if(top == null)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public void display()
    {
        Node temp = top;
        while(temp != null)
        {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class ImplementStackUsingLL {
    public static void main(String[] args) {
        Stack2 stack = new Stack2();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack elements:");
        stack.display();

        System.out.println("Top element is " + stack.peek());

        System.out.println("Popped element is " + stack.pop());
        System.out.println("Popped element is " + stack.pop());

        System.out.println("Stack elements after pop:");
        stack.display();

        System.out.println("Top element is " + stack.peek());

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
