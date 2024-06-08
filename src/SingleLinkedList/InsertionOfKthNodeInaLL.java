package SingleLinkedList;

public class InsertionOfKthNodeInaLL {

    static Node constructLL(int[] arr)
    {
        if(arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1; i<arr.length; i++)
        {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    static Node add(Node head, int val, int k)
    {
        if(head == null)
        {
            if(k==1)
            {
                return new Node(val);
            }
            else return head;
        }
        if(k == 1)
        {
            Node newHead = new Node(val);
            newHead.next = head;
            return newHead;
        }
        int count = 0;
        Node temp = head;
        while(temp != null)
        {
            count++;
            if(count == (k-1))
            {
                Node x = new Node(val);
                x.next = temp.next;
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    static void printLL(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7};
        Node head = constructLL(arr);
        head = add(head,100,5);
        printLL(head);
    }
}
