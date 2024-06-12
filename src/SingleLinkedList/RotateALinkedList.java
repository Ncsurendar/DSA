package SingleLinkedList;

public class RotateALinkedList {

    static Node rotate(Node head, int k)
    {
        if(head == null || head.next == null || k==0) return head;
        Node tail = head;
        int len = 1;
        while(tail.next != null)
        {
            len++;
            tail = tail.next;
        }
        if(k % len == 0) return head;
        k = k % len;

        tail.next = head;
        int dis = len - k;
        Node temp = tail;
        while(dis > 0)
        {
            temp = temp.next;
            dis--;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Rotate the list by k positions
        int k = 2;


        Node result = rotate(head, k);

        while(result != null)
        {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
