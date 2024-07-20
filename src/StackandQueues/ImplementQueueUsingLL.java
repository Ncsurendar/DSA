package StackandQueues;

class Queue1{
    private Node1 front, rear;
    public Queue1() {
        front = rear = null;
    }
    public void enqueue(int x)
    {
        Node1 newNode = new Node1(x);
        if(rear == null)
        {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue()
    {
        if(front == null)
        {
            System.out.println("No Element in the Queue");
            return -1;
        }
        int dequeuedData = front.data;
        front = front.next;
        if(front == null) rear = null;
        return dequeuedData;
    }

    public int peek()
    {
        if(front == null)
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty()
    {
        return front == null;
    }

    public void display()
    {
        if(front == null)
        {
            System.out.println("Queue is empty");
            return;
        }
        Node1 temp = front;
        while(temp != null)
        {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class ImplementQueueUsingLL {
    public static void main(String[] args) {
        Queue1 queue = new Queue1();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue elements:");
        queue.display();

        System.out.println("Front element is " + queue.peek());

        System.out.println("Dequeued element is " + queue.dequeue());
        System.out.println("Dequeued element is " + queue.dequeue());

        System.out.println("Queue elements after dequeue:");
        queue.display();

        System.out.println("Front element is " + queue.peek());

        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
