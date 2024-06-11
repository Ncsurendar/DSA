package SingleLinkedList;

public class LinkedListLoops {

    static boolean hasCycle(Node head)
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = head2.next;

        System.out.println(hasCycle(head2));
    }
}
