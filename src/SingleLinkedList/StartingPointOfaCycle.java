package SingleLinkedList;

public class StartingPointOfaCycle {

    static Node detectCycle(Node head)
    {
        if(head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;
        Node entry = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                while(slow != entry)
                {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = head2.next;
        Node cycleStart = detectCycle(head2);
        System.out.println(cycleStart.data);
    }
}
