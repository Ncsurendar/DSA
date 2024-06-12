package SingleLinkedList;

public class ReverseNodesInKGroups {

    public static Node reverseKGroup(Node head, int k)
    {
        if (head == null || k == 1) return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;

        while (true)
        {
            Node kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) break;

            Node groupStart = prevGroupEnd.next;
            Node nextGroupStart = kthNode.next;
            kthNode.next = null;

            prevGroupEnd.next = reverseLinkedList(groupStart);
            groupStart.next = nextGroupStart;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    private static Node getKthNode(Node start, int k)
    {
        while (start != null && k > 0)
        {
            start = start.next;
            k--;
        }
        return start;
    }

    private static Node reverseLinkedList(Node head)
    {
        Node prev = null;
        Node current = head;
        while (current != null)
        {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 3;
        Node result = reverseKGroup(head, k);
        while (result != null)
        {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
