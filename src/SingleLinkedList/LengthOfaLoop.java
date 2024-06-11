package SingleLinkedList;

public class LengthOfaLoop {

    static int countNodes(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return length(slow);
        }
        return 0;
    }

    static int length(Node slow)
    {
        int count = 0;
        Node current = slow;
        while(current.next != slow)
        {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = head2.next;

        int ans = countNodes(head2);
        System.out.println(ans);
    }
}
